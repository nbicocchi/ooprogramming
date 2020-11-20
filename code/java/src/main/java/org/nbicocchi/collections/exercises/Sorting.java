package org.nbicocchi.collections.exercises;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Collections class implements a set of useful methods for sorting and
 * searching Collection implementations (e.g., ArrayList, LinkedList).
 * <p>
 * 1. Develop a class Student comprising name, surname and average grade. Define
 * a natural ordering using the Comparable interface within the Student class.
 * More specifically, Student objects have to be sorted using both surname and
 * average (in case of identical surnames).
 * <p>
 * 2. Test the implemented solution using Collections.sort().
 * <p>
 * 3. Implement an alternative sorting (by name), without modifying the Student
 * class, by making use of the Comparator interface.
 *
 * @author Nicola Bicocchi
 */
public class Sorting {
    public static void main(String[] args) {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("Marco", "Rossi", 28.0));
        l.add(new Student("Giulia", "Bianchi", 24.0));
        l.add(new Student("Annalisa", "Verdi", 22.0));
        l.add(new Student("Carlo", "Verdi", 24.0));
        l.add(new Student("Luca", "Verdi", 22.0));

        System.out.println("1st Ordering...");
        Collections.sort(l);
        System.out.println(l);

        System.out.println("2nd Ordering...");
        l.sort((s0, s1) -> s0.getName().compareTo(s1.getName()));
        System.out.println(l);
    }
}
