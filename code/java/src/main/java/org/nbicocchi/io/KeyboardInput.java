package org.nbicocchi.io;

import org.nbicocchi.utils.Student;

import java.util.Scanner;

/**
 * Scanner is a class providing typed input from InputStreams (e.g.
 * System.in/Keyboard)
 *
 * @author Nicola Bicocchi
 */
public class KeyboardInput {
    public static void main(String[] args) {
        String name;
        String lastName;
        double average;

        Scanner scr = new Scanner(System.in);
        System.out.print("Insert name: ");
        name = scr.nextLine();

        System.out.print("Insert lastname: ");
        lastName = scr.nextLine();

        System.out.print("Insert average: ");
        average = scr.nextDouble();
        scr.close();

        Student s = new Student(name, lastName, average);
        System.out.println(s);
    }
}
