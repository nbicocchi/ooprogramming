package org.nbicocchi.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RationalTest {
    @Test
    public void constructorThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Rational(1, 0));
    }

    @Test
    public void plus() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        Rational r3 = r1.plus(r2);
        assertEquals(4.0, r3.getNumerator(), 0);
        assertEquals(4.0, r3.getDenominator(), 0);
    }

    @Test
    public void times() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        Rational r3 = r1.times(r2);
        assertEquals(1.0, r3.getNumerator(), 0);
        assertEquals(4.0, r3.getDenominator(), 0);
    }
}