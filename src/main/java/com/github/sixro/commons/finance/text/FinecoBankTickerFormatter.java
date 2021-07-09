package com.github.sixro.commons.finance.text;

import com.github.sixro.commons.finance.Market;
import com.github.sixro.commons.finance.Ticker;

import java.util.HashMap;
import java.util.Map;

public final class FinecoBankTickerFormatter implements TickerFormatter {

    private static final Map<Market, String> TEXT_BY_MARKET = new HashMap<>();
    static {
        TEXT_BY_MARKET.put(Market.NYSE, "N");
        TEXT_BY_MARKET.put(Market.NASDAQ, "O");
        TEXT_BY_MARKET.put(Market.ITALY, "MI");
    }

    private static final Map<String, Market> MARKET_BY_TEXT = new HashMap<>();
    static {
        MARKET_BY_TEXT.put("N", Market.NYSE);
        MARKET_BY_TEXT.put("O", Market.NASDAQ);
        MARKET_BY_TEXT.put("MI", Market.ITALY);
    }

    @Override
    public String format(Ticker ticker) {
        String code = ticker.getCode();
        Market market = ticker.getMarket();
        String marketAsText = TEXT_BY_MARKET.get(market);
        return String.format("%s.%s", code, marketAsText);
    }

    @Override
    public Ticker parse(String text) {
        int idx = text.indexOf(".");
        String code = text.substring(0, idx);
        String marketAsText = text.substring(idx + 1);
        Market market = MARKET_BY_TEXT.get(marketAsText);
        if (market == null)
            throw new UnsupportedOperationException("market not supported '" + marketAsText + "'");
        return Ticker.valueOf(code, market);
    }

}
