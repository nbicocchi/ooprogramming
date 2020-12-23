package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * Write a program in Java to display the multiplication table of a given
 * integer. n = 5, expected Output:
 * <p>
 * 5 X 0 = 0
 * <p>
 * 5 X 1 = 5
 * <p>
 * 5 X 2 = 10
 * <p>
 * 5 X 3 = 15
 * <p>
 * 5 X 4 = 20
 * <p>
 * 5 X 5 = 25
 * <p>
 * …
 *
 * @author Nicola Bicocchi
 */
public class Multiplication {
    public static void main(String[] args) {
        int j, n;

        System.out.print("Input the number(Table to be calculated): ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.close();

        System.out.println("\n");
        for (j = 0; j <= n; j++)
            System.out.println(n + " X " + j + " = " + n * j);
    }
}
