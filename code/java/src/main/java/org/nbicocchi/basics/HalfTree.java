package org.nbicocchi.basics;

/**
 * Write a program in Java to display the pattern below (n = 4)
 * <p>
 * Expected Output :
 * <p>
 * 1 12 123 1234
 *
 * @author Nicola Bicocchi
 */
public class HalfTree {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
