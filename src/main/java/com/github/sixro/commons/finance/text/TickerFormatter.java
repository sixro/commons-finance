package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Ticker;

import java.util.Formattable;

/**
 * Represents a ticker formatter.
 */
public interface TickerFormatter {

    /**
     * Returns a text representing the specified ticker.
     *
     * @param ticker the ticker
     * @return a text
     */
    String format(Ticker ticker);

    /**
     * Parse the specified text into a ticker.
     *
     * @param text the text
     * @return a ticker
     */
    Ticker parse(String text);

}
