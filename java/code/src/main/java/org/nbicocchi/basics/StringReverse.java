package org.nbicocchi.basics;

/**
 * Write a Java program to print a String object in reverse order.
 *
 * @author Nicola Bicocchi
 */
public class StringReverse {
    public static void main(String[] args) {
        String s = "String test";
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
