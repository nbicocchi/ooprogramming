package org.nbicocchi.lambda;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunctionalInterfaces {

    public static void main(String[] args) {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("John", "Doe", 28));
        l.add(new Student("Dimebag", "Darrell", 27));
        l.add(new Student("Gene", "Hoglan", 22));
        l.add(new Student("Tyler", "Durden", 26));
        l.add(new Student("Diana", "Krall", 23));
        l.add(new Student("Melody", "Gardot", 30));
        l.add(new Student("Tim", "Buckley", 21));

        System.out.println("processStudentsPredicate()...");
        processStudentsPredicate(l, (p) -> p.getAverage() >= 20 && p.getAverage() <= 24);

        System.out.println("processStudentsConsumer()...");
        processStudentsConsumer(
                l,
                (p) -> p.getAverage() >= 20 && p.getAverage() <= 24,
                System.out::println
        );

        System.out.println("processStudentsFunction()...");
        processStudentsFunction(
                l,
                (p) -> p.getAverage() >= 20 && p.getAverage() <= 24,
                Student::getName,
                System.out::println
        );

        System.out.println("processElements()...");
        processElements(
                l,
                (p) -> p.getAverage() >= 20 && p.getAverage() <= 24,
                Student::getName,
                System.out::println
        );
    }

    public static void processStudentsPredicate(List<Student> roster,
                                                Predicate<Student> tester) {
        for (Student p : roster) {
            if (tester.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void processStudentsConsumer(List<Student> roster,
                                               Predicate<Student> tester,
                                               Consumer<Student> consumer) {
        for (Student p : roster) {
            if (tester.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public static void processStudentsFunction(List<Student> roster,
                                               Predicate<Student> tester,
                                               Function<Student, String> mapper,
                                               Consumer<String> consumer) {
        for (Student p : roster) {
            if (tester.test(p)) {
                String s = mapper.apply(p);
                consumer.accept(s);
            }
        }
    }

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {

        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}
