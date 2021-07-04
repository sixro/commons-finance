package com.github.sixro.commons.finance;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an <a href="https://en.wikipedia.org/wiki/International_Securities_Identification_Number" >ISIN</a>.
 *
 * <p>
 * The validation has been done following <a href="https://www.isin.org/education/" >this specification</a>.
 * </p>
 */
public final class ISIN implements Comparable<ISIN>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final int START_OF_NUMS = 55;
    private static final int THRESHOLD = 10;

    private final String code;

    private ISIN(String code) {
        this.code = code;
        validate();
    }

    /**
     * Create an {@code ISIN} from its textual representation (for example {@code IE00BKM4GZ66}).
     *
     * @param code an ISIN code
     * @return an {@code ISIN}
     */
    public static ISIN valueOf(String code) {
        return new ISIN(code);
    }

    /*
     * See https://www.isin.org/education/
     */
    private void validate() {
        String textual = convertToNumbers();
        textual = reverse(textual);

        int calculatedCheckDigit = calculateCheckDigit(textual);
        int checkDigit = Integer.parseInt(code.substring(code.length() - 1));

        if (checkDigit != calculatedCheckDigit)
            throw new IllegalArgumentException("ISIN " + code + " is not a valid code (check digit " + checkDigit +
                " differs from calculated digit " + calculatedCheckDigit);
    }

    @Override
    public int compareTo(ISIN o) {
        return code.compareTo(o.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof ISIN))
            return false;
        return Objects.equals(code, ((ISIN) obj).code);
    }

    @Override
    public String toString() {
        return code;
    }

    private String convertToNumbers() {
        String textual = "";
        for (int i = 0; i < code.length() - 1; i++) {
            char ch = code.charAt(i);
            textual += (Character.isDigit(ch))
                    ? Character.toString(ch)
                    : ((int) ch) - START_OF_NUMS;
        }
        return textual;
    }

    private String reverse(String textual) {
        return new StringBuilder(textual).reverse().toString();
    }

    private int calculateCheckDigit(String textual) {
        int sum = 0;
        for (int i = 0; i < textual.length(); i++) {
            int v = Integer.parseInt(textual.substring(i, i + 1));
            if (i % 2 == 0) {
                v *= 2;
                sum += v % THRESHOLD;
                sum += v / THRESHOLD;
            } else {
                sum += v;
            }
        }

        return (THRESHOLD - (sum % THRESHOLD)) % THRESHOLD;
    }

}
