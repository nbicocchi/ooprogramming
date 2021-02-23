package org.nbicocchi.basics;

import java.util.Random;

/**
 * Write a program with a method named isEven() that accepts an int argument. The
 * method should return true if the argument is even, or false if otherwise. The
 * program's main method should use a loop to generate 100 random integers. It
 * should use the isEven method to determine whether each random number is even,
 * or odd. When the loop is finished, the program should display the number of
 * even and odd numbers that were generated.
 *
 * @author Justin Musgrove
 */
public class EvenOddCounter {
    private static final int RANDOM_NUMBERS = 100;

    public static void main(String[] args) {
        int evenNumberCount = 0;
        int oddNumberCount = 0;

        Random randomValue = new Random();

        // Generate 100 random numbers.
        for (int i = 1; i <= RANDOM_NUMBERS; i++) {
            // Determine if the number was even or odd.
            if (isEven(randomValue.nextInt(i))) {
                evenNumberCount++;
            } else {
                oddNumberCount++;
            }
        }

        System.out.println("Number of even numbers: " + evenNumberCount);
        System.out.println("Number of odd numbers: " + oddNumberCount);

    }

    /**
     * @param num to check
     * @return true if the num is true otherwise false
     */
    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}