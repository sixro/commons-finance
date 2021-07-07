package com.github.sixro.commons.finance;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents an OHLC-Volume.
 */
public final class OHLCV extends OHLC {

    private final long volume;

    /**
     * Creates an OHLC-Volume with specified values.
     *
     * @param dateTime date and time of this OHLC-Volume
     * @param open the open price
     * @param high the high price
     * @param low the low price
     * @param close the close price
     * @param volume the volume
     */
    public OHLCV(LocalDateTime dateTime, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, long volume) {
        super(dateTime, open, high, low, close);
        if (volume < 0)
            throw new IllegalArgumentException("volume must be greater than or equal to 0");
        this.volume = volume;
    }

    /**
     * Returns the volume.
     *
     * @return the volume
     */
    public long getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OHLCV ohlcv = (OHLCV) o;
        return volume == ohlcv.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }

    @Override
    public String toString() {
        return "<O=" + getOpen() + ", H=" + getHigh() + ", L=" + getLow() + ", C=" + getClose() + ", V=" + volume + "@"
            + DATE_TIME_FORMATTER.format(getDateTime()) + ">";
    }

}
