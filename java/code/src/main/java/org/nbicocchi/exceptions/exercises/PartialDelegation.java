package org.nbicocchi.exceptions.exercises;

/**
 * Partial delegation consist in intercepting one exception eventually generated
 * within a try block and, in the catch block, throwing another exception.
 * <p>
 * Create a class Test comprising two methods, f() and g().
 * <p>
 * In g(), throw an exception gException.
 * <p>
 * In f(), call g(), catch gException and throw a new exception fException.
 * <p>
 * Test your code with the main method below.
 *
 * @author Nicola Bicocchi
 */
public class PartialDelegation {
    public static void main(String[] args) {
        PartialDelegation t = new PartialDelegation();
        try {
            t.f();
        } catch (fException e) {
            e.printStackTrace();
        }
    }

    public void f() throws fException {
        try {
            g();
        } catch (gException e) {
            throw new fException();
        }
    }

    public void g() throws gException {
        throw new gException();
    }
}
