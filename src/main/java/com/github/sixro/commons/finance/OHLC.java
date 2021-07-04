package com.github.sixro.commons.finance;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents an Open-High-Low-Close.
 */
public final class OHLC {

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
        if (dateTime == null)
            throw new IllegalArgumentException("dateTime is required");
        if (open == null)
            throw new IllegalArgumentException("open is required");
        if (high == null)
            throw new IllegalArgumentException("high is required");
        if (low == null)
            throw new IllegalArgumentException("low is required");
        if (close == null)
            throw new IllegalArgumentException("close is required");
        
        this.dateTime = dateTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OHLC ohlc = (OHLC) o;
        return Objects.equals(dateTime, ohlc.dateTime) && Objects.equals(open, ohlc.open) && Objects.equals(high, ohlc.high) && Objects.equals(low, ohlc.low) && Objects.equals(close, ohlc.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, open, high, low, close);
    }

    public String toString() {
        return "<O=" + open + ", H=" + high + ", L=" + low + ", C=" + close + "@"
            + DATE_TIME_FORMATTER.format(dateTime) + ">";
    }

}
