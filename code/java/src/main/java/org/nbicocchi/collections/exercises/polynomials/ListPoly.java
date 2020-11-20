package org.nbicocchi.collections.exercises.polynomials;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a polynomial with coefficients stored as a list
 *
 * @author Nicola Bicocchi
 */
public class ListPoly extends AbstractPoly implements Poly {
    List<Double> c;

    public ListPoly(double[] coeffs) {
        if (coeffs == null || coeffs.length == 0) {
            throw new IllegalArgumentException();
        }

        c = new ArrayList<>();
        for (double coeff : coeffs) c.add(coeff);
    }

    @Override
    public int degree() {
        return c.size() - 1;
    }

    @Override
    public Poly derivative() {
        return new ListPoly(derive());
    }

    @Override
    public double coefficient(int degree) {
        if (degree > degree() || degree < 0)
            throw new IllegalArgumentException();
        return c.get(degree);
    }

}
