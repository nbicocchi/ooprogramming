package org.nbicocchi.exceptions.exercises;

/**
 * Create a class with a main() method throwing an Exception inside a try block.
 * Provide the Exception constructor with a String argument representing a
 * message.
 * <p>
 * Catch the exception within a catch block and print the contained message.
 * <p>
 * Add a finally block and print a message to prove that it has been executed.
 *
 * @author Nicola Bicocchi
 */
public class Throw {
    public static void main(String[] args) {
        try {
            throw new Exception("Issue!");
        } catch (Exception e) {
            System.out.println("[CATCH BLOCK] -> " + e.getMessage());
        } finally {
            System.out.println("[FINALLY BLOCK]");
        }
    }

}
