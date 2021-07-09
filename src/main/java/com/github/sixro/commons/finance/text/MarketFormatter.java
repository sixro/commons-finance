package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;

/**
 * Represents a market formatter and parser.
 */
public interface MarketFormatter {

    /**
     * Returns a text formatting the specified market.
     *
     * @param market the market
     * @return a text
     */
    String format(Market market);

    /**
     * Returns a market parsing the specified text.
     *
     * @param text the text
     * @return a market
     */
    Market parse(String text);

}
