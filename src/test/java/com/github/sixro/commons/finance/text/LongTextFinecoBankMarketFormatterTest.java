package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongTextFinecoBankMarketFormatterTest {

    private LongTextFinecoBankMarketFormatter formatter = new LongTextFinecoBankMarketFormatter();

    @Test public void format_italy() {
        assertEquals("AFF", formatter.format(Market.ITALY));
    }

    @Test public void format_nasdaq() {
        assertEquals("NASDAQ", formatter.format(Market.NASDAQ));
    }

    @Test public void parse_italy() {
        assertEquals(Market.ITALY, formatter.parse("AFF"));
    }

    @Test public void parse_failure() {
        assertThrows(IllegalArgumentException.class, () -> formatter.parse("XXX"));
    }

}