package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a market formatter based on a mapping.
 */
@SuppressWarnings("checkstyle:DesignForExtension")
public class MapBasedMarketFormatter implements MarketFormatter {

    private final Map<Market, String> textByMarket;
    private final Map<String, Market> marketByText;

    /**
     * Creates a market formatter using the specified mapping.
     *
     * @param textByMarket the mapping
     */
    public MapBasedMarketFormatter(Map<Market, String> textByMarket) {
        this.textByMarket = textByMarket;
        this.marketByText = invert(textByMarket);
    }

    @Override
    public String format(Market market) {
        String text = textByMarket.get(market);
        if (text == null)
            throw new IllegalArgumentException("Unknown market " + market);
        return text;
    }

    @Override
    public Market parse(String text) {
        Market market = marketByText.get(text);
        if (market == null)
            throw new IllegalArgumentException("Unknown market " + text);
        return market;
    }

    private static Map<String, Market> invert(Map<Market, String> map) {
        Map<String, Market> ret = new HashMap<>();
        for (Map.Entry<Market, String> e: map.entrySet())
            ret.put(e.getValue(), e.getKey());
        return ret;
    }
}
