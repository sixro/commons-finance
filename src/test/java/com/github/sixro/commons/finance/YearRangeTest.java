package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YearRangeTest {

    @Test public void size() {
        assertEquals(BigDecimal.valueOf(9), new YearRange(BigDecimal.TEN, BigDecimal.ONE).size());
    }

    @Test public void validate() {
        assertThrows(IllegalArgumentException.class, () -> new YearRange(BigDecimal.ZERO, BigDecimal.ONE));
    }

    @Test public void equality() {
        assertEquals(new YearRange(BigDecimal.ONE, BigDecimal.ZERO), new YearRange(new BigDecimal("1.00"), new BigDecimal("0.00")));
    }

}