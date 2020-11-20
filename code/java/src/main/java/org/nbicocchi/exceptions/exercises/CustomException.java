package org.nbicocchi.exceptions.exercises;

/**
 * Create a custom exception MyException using the extends keyword.
 * <p>
 * Test MyException using the main() method below.
 *
 * @author Nicola Bicocchi
 */
public class CustomException {
    public static void main(String[] args) {
        try {
            throw new fException("This is a custom exception!");
        } catch (fException e) {
            System.out.println(e.getMessage());
        }
    }
}
