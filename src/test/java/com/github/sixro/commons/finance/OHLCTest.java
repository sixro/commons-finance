package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OHLCTest {

    @Test public void no_null() {
        assertThrows(NullPointerException.class, () -> new OHLC(null, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), null, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, null, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.ONE, null, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, null));
    }

    @Test public void no_wrong_params() {
        assertThrows(IllegalArgumentException.class, () -> aOHLC(LocalDateTime.now(), 1, 0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> aOHLC(LocalDateTime.now(), 1, 1, 2, 1));
        assertThrows(IllegalArgumentException.class, () -> aOHLC(LocalDateTime.now(), 1, 1, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> aOHLC(LocalDateTime.now(), 1, 1, 2, 1));
        assertThrows(IllegalArgumentException.class, () -> aOHLC(LocalDateTime.now(), 2, 2, 2, 1));
    }

    @Test public void valid() {
        OHLC ohlc = new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.valueOf(5));
        System.out.println(ohlc);
    }

    @Test public void highest_low() {
        LocalDateTime today = today();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime theDayBefore = today.minusDays(2);

        List<OHLC> list = Arrays.asList(
            aOHLC(today, 1, 4, 0, 2),
            aOHLC(yesterday, 2, 5, 1, 3),
            aOHLC(theDayBefore, 3, 6, 2, 4)
        );
        BigDecimal hl = OHLCV.highestLow(list);
        assertEquals(2, hl.intValue());
    }

    @Test public void highest_low_with_multiple_results() {
        LocalDateTime today = today();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime theDayBefore = today.minusDays(2);

        List<OHLC> list = Arrays.asList(
            aOHLC(today, 1, 4, 0, 2),
            aOHLC(yesterday, 2, 5, 2, 3),
            aOHLC(theDayBefore, 3, 6, 2, 4)
        );
        BigDecimal hl = OHLCV.highestLow(list);
        assertEquals(2, hl.intValue());
    }

    @Test public void highest_high() {
        LocalDateTime today = today();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime theDayBefore = today.minusDays(2);

        List<OHLC> list = Arrays.asList(
            aOHLC(today, 1, 4, 0, 2),
            aOHLC(yesterday, 2, 5, 1, 3),
            aOHLC(theDayBefore, 3, 6, 2, 4)
        );
        BigDecimal hh = OHLCV.highestHigh(list);
        assertEquals(6, hh.intValue());
    }

    public static OHLC aOHLC(LocalDateTime dt, int o, int h, int l, int c) {
        return new OHLC(dt, BigDecimal.valueOf(o), BigDecimal.valueOf(h), BigDecimal.valueOf(l), BigDecimal.valueOf(c));
    }

    private static LocalDateTime today() {
        return LocalDateTime.now()
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0);
    }

}