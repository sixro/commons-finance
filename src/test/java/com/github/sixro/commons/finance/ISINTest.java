package com.github.sixro.commons.finance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ISINTest {

    @Test
    public void create_valid() {
        assertNotNull(ISIN.valueOf("US0004026250"));
    }

    @Test
    public void create_valid_even_with_letters_in_the_middle() {
        assertNotNull(ISIN.valueOf("IE00BKM4GZ66"));
    }

    @Test
    public void fail_when_invalid() {
        assertThrows(IllegalArgumentException.class, () -> ISIN.valueOf("abc"));
    }

    @Test public void comparable() {
        ISIN ie = ISIN.valueOf("IE00BKM4GZ66");
        ISIN us = ISIN.valueOf("US0004026250");
        List<ISIN> l = Arrays.asList(us, ie);
        Collections.sort(l);
        assertEquals(ie, l.get(0));
    }
}