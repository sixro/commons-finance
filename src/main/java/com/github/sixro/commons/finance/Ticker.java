package com.github.sixro.commons.finance;

import java.util.Objects;

/**
 * Represents a ticker.
 */
public final class Ticker {

    private final String code;
    private final Market market;

    private Ticker(String code, Market market) {
        if (code == null || code.isBlank())
            throw new IllegalArgumentException("code is required");
        if (market == null)
            throw new IllegalArgumentException("market is required");
        this.code = code;
        this.market = market;
    }

    /**
     * Returns a ticker using specified code and market.
     *
     * @param code the code
     * @param market the market
     * @return a ticker
     */
    public static Ticker valueOf(String code, Market market) {
        return new Ticker(code, market);
    }

    /**
     * Returns the code of this ticker.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the market of this ticker.
     *
     * @return the market
     */
    public Market getMarket() {
        return market;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticker ticker = (Ticker) o;
        return Objects.equals(code, ticker.code) && market == ticker.market;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, market);
    }

    @Override
    public String toString() {
        return "Ticker{" + "code='" + code + '\'' + ", market=" + market + '}';
    }
}
