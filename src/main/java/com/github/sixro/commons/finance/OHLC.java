package com.github.sixro.commons.finance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents an Open-High-Low-Close.
 */
@SuppressWarnings("PMD.ExcessivePublicCount")
public final class OHLC implements Comparable<OHLC>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private final LocalDateTime dateTime;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;

    /**
     * Creates an OHLC using specified values.
     *
     * @param dateTime date and time of this OHLC
     * @param open the open price
     * @param high the high price
     * @param low the low price
     * @param close the close price
     */
    public OHLC(LocalDateTime dateTime, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        Objects.requireNonNull(dateTime, "dateTime is required");
        Objects.requireNonNull(open, "open is required");
        Objects.requireNonNull(high, "high is required");
        Objects.requireNonNull(low, "low is required");
        Objects.requireNonNull(close, "close is required");

        this.dateTime = dateTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    /**
     * Returns the date and time.
     *
     * @return the date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Returns the open price.
     *
     * @return the open price
     */
    public BigDecimal getOpen() {
        return open;
    }

    /**
     * Returns the high price.
     *
     * @return the high price
     */
    public BigDecimal getHigh() {
        return high;
    }

    /**
     * Returns the low price.
     *
     * @return the low price
     */
    public BigDecimal getLow() {
        return low;
    }

    /**
     * Returns the close price.
     *
     * @return the close price
     */
    public BigDecimal getClose() {
        return close;
    }

    @Override
    public int compareTo(OHLC o) {
        return dateTime.compareTo(o.dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OHLC ohlc = (OHLC) o;
        return Objects.equals(dateTime, ohlc.dateTime) && Objects.equals(open, ohlc.open) && Objects.equals(high, ohlc.high)
            && Objects.equals(low, ohlc.low) && Objects.equals(close, ohlc.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, open, high, low, close);
    }

    @Override
    public String toString() {
        return "<O=" + open + ", H=" + high + ", L=" + low + ", C=" + close + "@"
            + DATE_TIME_FORMATTER.format(dateTime) + ">";
    }

}
