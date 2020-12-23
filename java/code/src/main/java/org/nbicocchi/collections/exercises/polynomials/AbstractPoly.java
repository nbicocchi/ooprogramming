package org.nbicocchi.collections.exercises.polynomials;

/**
 * An abstract class providing an implementation for shared parts of ArrayPoly
 * and ListPoly
 *
 * @author Nicola Bicocchi
 */
public abstract class AbstractPoly implements Poly {

    double[] derive() {
        double[] tmp = new double[Math.max(1, degree())];
        for (int i = 1; i <= degree(); i++) {
            tmp[i - 1] = coefficient(i) * i;
        }
        return tmp;
    }

    @Override
    public boolean equals(Poly q) {
        if (q == null || degree() != q.degree())
            return false;

        boolean equal = true;
        for (int i = 0; i <= degree() && equal; i++)
            equal = (coefficient(i) == q.coefficient(i));

        return equal;
    }

    @Override
    public String toString() {
        if (degree() == 0)
            return "" + coefficient(0);

        String out = (coefficient(0) == 0) ? "" : "" + coefficient(0) + " + ";
        for (int i = 1; i < degree(); i++) {
            if (coefficient(i) != 0)
                out += coefficient(i) + "x^" + i + " + ";
        }

        return out += coefficient(degree()) + "x^" + degree();
    }
}
