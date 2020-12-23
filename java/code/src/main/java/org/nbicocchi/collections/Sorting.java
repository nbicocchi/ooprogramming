package org.nbicocchi.collections;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class showing how to use both Comparable and Comparator interfaces
 *
 * @author Nicola Bicocchi
 */
public class Sorting {
    public static void main(String[] args) {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("Nicola", "Rossi", 28));
        l.add(new Student("Paolo", "Rossi", 25));
        l.add(new Student("Nicola", "Bianchi", 23));

        for (Student s : l) {
            System.out.println(s);
        }
        System.out.println();

        /*
         * Sorting using natural ordering. Comparable must be implemented while equals()
         * and hashcode() must be overridden in student class for defining an order
         */
        Collections.sort(l);

        for (Student s : l) {
            System.out.println(s);
        }
        System.out.println();

        /*
         * Sorting using a comparator
         */
        l.sort((s0, s1) -> Double.compare(s0.getAverage(), s1.getAverage()));

        for (Student s : l) {
            System.out.println(s);
        }
    }

}
