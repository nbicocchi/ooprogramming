package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * Write program in java that accepts users input and validates if the input is
 * a palindrome. A palindrome is a word that reads the same forwards as it does
 * backwards. For this exercise we will consider a palindrome a palindrome
 * without punctuation.
 *
 * @author Justin Musgrove
 */
public class PalindromeDiscoverer {

    public static void main(String[] args) {

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a word or phrase: ");
        String userInput = keyboard.nextLine();

        boolean isAPalindrome = isPalindrome(userInput);

        if (isAPalindrome) {
            System.out.print("The word or phrase is a palindrome");
        } else {
            System.out.print("Sorry the word or phrase is NOT a palindrome");
        }

        keyboard.close();
    }

    /**
     * Method should return true if a string is identified as a palindrome.
     * There are many ways to do a palindrome check, this is just one of them.
     * If you are performing checks on very, very long strings you may want to
     * consider another algorithm.
     *
     * @param str the string to be verified
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String str) {

        if (str.length() <= 1) {
            return true;
        } else {
            String toCompare = str.replaceAll("\\s+", "");

            StringBuilder buffer = new StringBuilder(toCompare);
            String reversedString = buffer.reverse().toString();

            return reversedString.equalsIgnoreCase(toCompare);
        }
    }

}
