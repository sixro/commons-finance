package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;
import com.github.sixro.commons.finance.Ticker;

/**
 * Represents a ticker formatter for FinecoBank.
 */
public final class FinecoBankTickerFormatter implements TickerFormatter {

    private final MarketFormatter marketFormatter;

    /**
     * Creates a FinecoBank ticker formatter using a short text for market.
     */
    public FinecoBankTickerFormatter() {
        this(new ShortTextFinecoBankMarketFormatter());
    }

    /**
     * Creates a FinecoBank ticker formatter using the specified market formatter.
     *
     * @param marketFormatter the market formatter
     */
    public FinecoBankTickerFormatter(MarketFormatter marketFormatter) {
        this.marketFormatter = marketFormatter;
    }

    @Override
    public String format(Ticker ticker) {
        String code = ticker.getCode();
        Market market = ticker.getMarket();
        String marketAsText = marketFormatter.format(market);
        return String.format("%s.%s", code, marketAsText);
    }

    @Override
    public Ticker parse(String text) {
        int idx = text.indexOf(".");
        String code = text.substring(0, idx);
        String marketAsText = text.substring(idx + 1);
        Market market = marketFormatter.parse(marketAsText);
        return Ticker.valueOf(code, market);
    }

}
