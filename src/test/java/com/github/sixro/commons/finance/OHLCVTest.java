package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OHLCVTest {

    @Test public void validate() {
        assertThrows(IllegalArgumentException.class, () -> aOHLCV(today(), 1, 1, 1, 1, -1000));
    }

    @Test
    public void highest_high_also_on_OHLCV() {
        LocalDateTime today = today();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime theDayBefore = today.minusDays(2);

        List<OHLCV> list = Arrays.asList(
            aOHLCV(today, 1, 4, 0, 2, 10),
            aOHLCV(yesterday, 2, 5, 1, 3, 15),
            aOHLCV(theDayBefore, 3, 6, 2, 4, 20)
        );
        BigDecimal hh = OHLCV.highestHigh(list);
        assertEquals(6, hh.intValue());
    }

    public static OHLCV aOHLCV(LocalDateTime dt, int o, int h, int l, int c, int v) {
        return new OHLCV(dt, BigDecimal.valueOf(o), BigDecimal.valueOf(h), BigDecimal.valueOf(l), BigDecimal.valueOf(c), v);
    }

    private static LocalDateTime today() {
        return LocalDateTime.now()
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0);
    }

}