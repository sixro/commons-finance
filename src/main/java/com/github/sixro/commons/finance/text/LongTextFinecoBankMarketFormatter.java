package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a FinecoBank market formatter using long text representations.
 */
public final class LongTextFinecoBankMarketFormatter extends MapBasedMarketFormatter {

    private static final Map<Market, String> MARKET_TO_TEXT = new HashMap<>();
    static {
        MARKET_TO_TEXT.put(Market.ITALY, "AFF");
        MARKET_TO_TEXT.put(Market.NASDAQ, Market.NASDAQ.name());
        MARKET_TO_TEXT.put(Market.NYSE, Market.NYSE.name());
    }

    /**
     * Creates a long text FinecoBank market formatter.
     */
    public LongTextFinecoBankMarketFormatter() {
        super(MARKET_TO_TEXT);
    }

}
