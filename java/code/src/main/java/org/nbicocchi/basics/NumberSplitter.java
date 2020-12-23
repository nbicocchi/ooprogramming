package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * Write a Java program to break an integer into a sequence of individual
 * digits. Test Data Input six non-negative digits: 123456
 * <p>
 * Expected Output
 * <p>
 * 1 2 3 4 5 6
 *
 * @author Nicola Bicocchi
 */
public class NumberSplitter {
    public static void main(String[] args) {
        System.out.print("Input a number: ");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        int digits = Integer.toString(input).length();
        for (int d = digits - 1; d >= 0; d--) {
            int n = input / ((int) Math.pow(10, d)) % 10;
            System.out.print(n + " ");
        }
    }
}