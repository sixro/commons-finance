package testing;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigDecimalAsserts {

    private BigDecimalAsserts() { }

    public static void assertBigDecimalEquals(String message, BigDecimal expected, BigDecimal actual) {
        final int EQUALS = 0;
        assertTrue(expected.compareTo(actual) == EQUALS, message + " (expected " + expected + ", got " + actual + ")");
    }
}
