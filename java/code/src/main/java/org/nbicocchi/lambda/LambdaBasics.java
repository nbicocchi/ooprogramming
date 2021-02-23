package org.nbicocchi.lambda;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.List;

public class LambdaBasics {
    public static void main(String[] args) {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("John", "Doe", 28));
        l.add(new Student("Dimebag", "Darrell", 27));
        l.add(new Student("Gene", "Hoglan", 22));
        l.add(new Student("Tyler", "Durden", 26));
        l.add(new Student("Diana", "Krall", 23));
        l.add(new Student("Melody", "Gardot", 30));
        l.add(new Student("Tim", "Buckley", 21));

        System.out.println("printStudentsWithAverage()...");
        printStudentsWithAverage(l, 25);

        System.out.println("printStudentsWithinAverageRange()...");
        printStudentsWithinAverageRange(l, 20, 24);

        System.out.println("printStudents()...");
        printStudents(l, new CheckPersonEligibleForSelectiveService());

        System.out.println("printStudents() with anonymous class...");
        printStudents(l, p -> p.getAverage() >= 20 && p.getAverage() <= 24);

        System.out.println("printStudents() with lambda expression...");
        printStudents(l, (p) -> p.getAverage() >= 20 && p.getAverage() <= 24);
    }

    public static void printStudentsWithAverage(List<Student> roster, double average) {
        for (Student p : roster) {
            if (p.getAverage() >= average) {
                System.out.println(p);
            }
        }
    }

    public static void printStudentsWithinAverageRange(List<Student> roster, int low, int high) {
        for (Student p : roster) {
            if (low <= p.getAverage() && p.getAverage() < high) {
                System.out.println(p);
            }
        }
    }

    public static void printStudents(List<Student> roster, CheckStudent tester) {
        for (Student p : roster) {
            if (tester.test(p)) {
                System.out.println(p);
            }
        }
    }
}
