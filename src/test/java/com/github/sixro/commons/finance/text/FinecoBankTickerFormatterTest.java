package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;
import com.github.sixro.commons.finance.Ticker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinecoBankTickerFormatterTest {

    private FinecoBankTickerFormatter formatter = new FinecoBankTickerFormatter();

    @Test public void format_nasdaq() {
        String text = formatter.format(Ticker.valueOf("CYCN", Market.NASDAQ));
        assertEquals("CYCN.O", text);
    }

    @Test public void format_nyse() {
        String text = formatter.format(Ticker.valueOf("ASAN", Market.NYSE));
        assertEquals("ASAN.N", text);
    }

    @Test public void format_italy() {
        String text = formatter.format(Ticker.valueOf("ENI", Market.ITALY));
        assertEquals("ENI.MI", text);
    }

    @Test public void parse_nasdaq() {
        Ticker expected = Ticker.valueOf("CYCN", Market.NASDAQ);
        Ticker ticker = formatter.parse("CYCN.O");
        assertEquals(expected, ticker);
    }

    @Test public void parse_fails() {
        assertThrows(IllegalArgumentException.class, () -> formatter.parse("CYCN.XYZ"));
    }

    @Test public void parse_nyse() {
        Ticker expected = Ticker.valueOf("ASAN", Market.NYSE);
        Ticker ticker = formatter.parse("ASAN.N");
        assertEquals(expected, ticker);
    }

    @Test public void parse_italy() {
        Ticker expected = Ticker.valueOf("ENI", Market.ITALY);
        Ticker ticker = formatter.parse("ENI.MI");
        assertEquals(expected, ticker);
    }

}