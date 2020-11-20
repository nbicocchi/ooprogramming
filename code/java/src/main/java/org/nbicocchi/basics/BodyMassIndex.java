package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * Write a program that calculates and displays a person's body mass index
 * (BMI). A person's BMI is calculated with the following formula: BMI = weight
 * (kg) / height (m) ^ 2. Display a message indicating whether the person has
 * optimal weight, is underweight, or is overweight. A sedentary person's weight
 * is considered optimal if his or her BMI is between 18.5 and 25. If the BMI is
 * less than 18.5, the person is considered underweight. If the BMI value is
 * greater than 25, the person is considered overweight.
 *
 * @author Justin Musgrove
 */
public class BodyMassIndex {

    public static void main(String[] args) {

        // Variables
        double weight; // The user's weight
        double height; // The user's height
        double bmi; // The user's BMI

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Tell the user what the program will do.
        System.out.println("This program will calculate your body mass index, or BMI.");

        // Get the user's weight.
        System.out.print("Enter your weight, in kg: ");
        weight = keyboard.nextDouble();

        // Get the user's height.
        System.out.print("Enter your height, in m: ");
        height = keyboard.nextDouble();

        // Calculate the user's body mass index.
        bmi = calculateBMI(height, weight);

        // Display the user's BMI.
        System.out.println("Your body mass index (BMI) is " + bmi);

        System.out.println(bmiDescription(bmi));

        keyboard.close();
    }

    /**
     * Method should calculate bmi
     *
     * @param height height of the person
     * @param weight weight of the person
     * @return bmi of the person
     */
    static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    /**
     * Method should return description based on bmi
     *
     * @param bmi bmi of the person
     * @return human readable description of bmi
     */
    static String bmiDescription(double bmi) {
        if (bmi < 18.5) {
            return "You are underweight.";
        } else {
            if (bmi > 25) {
                return "You are overweight.";
            } else {
                return "Your weight is optimal.";
            }
        }
    }
}
