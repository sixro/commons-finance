package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a FinecoBank market formatter using short text representations.
 */
public final class ShortTextFinecoBankMarketFormatter extends MapBasedMarketFormatter {

    private static final Map<Market, String> MARKET_TO_TEXT = new HashMap<>();
    static {
        MARKET_TO_TEXT.put(Market.ITALY, "MI");
        MARKET_TO_TEXT.put(Market.NASDAQ, "O");
        MARKET_TO_TEXT.put(Market.NYSE, "N");
    }

    /**
     * Creates a short text FinecoBank market formatter.
     */
    public ShortTextFinecoBankMarketFormatter() {
        super(MARKET_TO_TEXT);
    }
}
