package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TickerTest {

    @Test public void validate() {
        assertThrows(IllegalArgumentException.class, () -> Ticker.valueOf(null, Market.ITALY));
        assertThrows(IllegalArgumentException.class, () -> Ticker.valueOf(" ", Market.ITALY));
        assertThrows(IllegalArgumentException.class, () -> Ticker.valueOf("ENI", null));
    }

    @Test public void good_ticker() {
        assertEquals(Market.NYSE, Ticker.valueOf("ASAN", Market.NYSE).getMarket());
    }

}