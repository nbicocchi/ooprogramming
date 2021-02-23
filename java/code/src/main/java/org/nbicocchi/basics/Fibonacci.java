package org.nbicocchi.basics;

/**
 * Write a program to display the first n numbers of the Fibonacci series.
 *
 * @author Nicola Bicocchi
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        long[] fibonacci = new long[n];

        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("[id=%d, fibonacci=%d]\n", i, fibonacci[i]);
        }
    }
}
