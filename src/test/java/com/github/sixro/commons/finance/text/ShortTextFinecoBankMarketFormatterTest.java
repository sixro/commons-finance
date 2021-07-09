package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShortTextFinecoBankMarketFormatterTest {

    private ShortTextFinecoBankMarketFormatter formatter = new ShortTextFinecoBankMarketFormatter();

    @Test
    public void format_italy() {
        assertEquals("MI", formatter.format(Market.ITALY));
    }

    @Test public void format_nasdaq() {
        assertEquals("O", formatter.format(Market.NASDAQ));
    }

    @Test public void parse_italy() {
        assertEquals(Market.ITALY, formatter.parse("MI"));
    }

    @Test public void parse_failure() {
        assertThrows(IllegalArgumentException.class, () -> formatter.parse("XXX"));
    }

}