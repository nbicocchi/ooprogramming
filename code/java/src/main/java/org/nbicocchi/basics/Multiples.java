package org.nbicocchi.basics;

/**
 * Write a program printing integers (1 < n < 100) divisible by 3 and 5
 *
 * @author Nicola Bicocchi
 */
public class Multiples {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
        }
    }

}
