package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * One acre of land is equivalent to 43,560 square feet. Write a program that
 * calculates the number of acres in a tract of land (expressed in square
 * feet).
 *
 * @author Justin Musgrove
 */
public class LandCalculation {

    private static final int FEET_PER_ACRE = 43560;

    public static void main(String[] args) {
        double feet; // tract in feet
        double acres; // To hold number of acres

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Tell the user what the program will do.
        System.out.println("This program will calculate number of acres.");

        // Get the tract in feet.
        System.out.print("Enter tract in square feet: ");
        feet = keyboard.nextDouble();

        acres = feet / FEET_PER_ACRE;

        // Display the results.
        System.out.printf("A tract of land with %.2f square feet has %.2f acres.", feet, acres);

        keyboard.close();
    }
}
