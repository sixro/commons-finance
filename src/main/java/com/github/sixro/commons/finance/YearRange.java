package com.github.sixro.commons.finance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents the year price range of a stock.
 */
public final class YearRange implements Serializable {

    private static final long serialVersionUID = 1L;

    private final BigDecimal high;
    private final BigDecimal low;

    /**
     * Creates an year range with specified high and low.
     *
     * @param high the high
     * @param low the low
     */
    public YearRange(BigDecimal high, BigDecimal low) {
        if (high.compareTo(low) < 0) {
            String m = "high must be greater than or equal to low (got high: " + high + " and low: " + low + ")";
            throw new IllegalArgumentException(m);
        }

        this.high = high;
        this.low = low;
    }

    /**
     * Returns the high.
     *
     * @return the high
     */
    public BigDecimal getHigh() {
        return high;
    }

    /**
     * Returns the low.
     *
     * @return the low
     */
    public BigDecimal getLow() {
        return low;
    }

    /**
     * Returns the size (or range) of this year range.
     *
     * @return the size of this year range
     */
    public BigDecimal size() {
        return high.subtract(low);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearRange yearRange = (YearRange) o;
        return high.compareTo(yearRange.high) == 0 && low.compareTo(yearRange.low) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(high, low);
    }

    @Override
    public String toString() {
        return "(" + high + "-" + low + ')';
    }

}
