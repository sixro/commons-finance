package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OHLCTest {

    @Test public void validate() {
        assertThrows(NullPointerException.class, () -> new OHLC(null, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), null, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, null, BigDecimal.ONE, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.ONE, null, BigDecimal.ONE));
        assertThrows(NullPointerException.class, () -> new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, null));
    }

    @Test public void valid() {
        OHLC ohlc = new OHLC(LocalDateTime.now(), BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.valueOf(5));
        System.out.println(ohlc);
    }
}