package org.nbicocchi.collections.exercises.polynomials;

/**
 * Class representing a polynomial with coefficients stored as on array of
 * doubles
 *
 * @author Nicola Bicocchi
 */
public class ArrayPoly extends AbstractPoly implements Poly {
    private final double[] c;

    public ArrayPoly(double[] c) {
        if (c == null || c.length == 0) {
            throw new IllegalArgumentException();
        }

        this.c = new double[c.length];
        System.arraycopy(c, 0, this.c, 0, c.length);
    }

    @Override
    public int degree() {
        return c.length - 1;
    }

    @Override
    public Poly derivative() {
        return new ArrayPoly(derive());
    }

    @Override
    public double coefficient(int degree) {
        if (degree > degree() || degree < 0)
            throw new IllegalArgumentException();
        return c[degree];
    }

}
