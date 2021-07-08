package com.github.sixro.commons.finance;

import java.time.ZoneId;
import java.util.Currency;
import java.util.TimeZone;

/**
 * Represents a market.
 */
public enum Market {
    /**
     * Represents the NYSE market.
     */
    NYSE(TimeZone.getTimeZone("America/New_York"), Currency.getInstance("USD")),
    /**
     * Represents the NASDAQ market.
     */
    NASDAQ(TimeZone.getTimeZone("America/New_York"), Currency.getInstance("USD")),
    /**
     * Represents the Italy market.
     *
     * <p>
 *     It is known also as Milan or &quot;Piazza Affari&quot;.
     * </p>
     */
    ITALY(TimeZone.getTimeZone("Europe/Rome"), Currency.getInstance("EUR"));

    private final TimeZone timeZone;
    private final Currency currency;

    Market(TimeZone timeZone, Currency currency) {
        this.timeZone = timeZone;
        this.currency = currency;
    }

    /**
     * Returns the time zone of this market.
     *
     * @return the time zone
     */
    public TimeZone timeZone() {
        return timeZone;
    }

    /**
     * Returns the {@code ZoneId} of this market.
     *
     * @return the {@code ZoneId}
     */
    public ZoneId zoneId() {
        return timeZone.toZoneId();
    }

    /**
     * Returns the currency of this market.
     *
     * @return the currency
     */
    public Currency currency() {
        return currency;
    }

}
