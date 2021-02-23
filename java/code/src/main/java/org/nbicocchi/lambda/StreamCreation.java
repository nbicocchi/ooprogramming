package org.nbicocchi.lambda;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        Stream<Student> s;

        /* Builder and accept() */
        s = getStreamBuilderAccept();
        s.forEach(System.out::println);

        /* Builder and add() */
        s = getStreamBuilderAdd();
        s.forEach(System.out::println);

        /* Stream.of() */
        s = getStreamOf();
        s.forEach(System.out::println);

        /* Stream from List */
        s = getStreamFromList();
        s.forEach(System.out::println);

        /* Stream from Array */
        s = getStreamFromArray();
        s.forEach(System.out::println);
    }

    public static Stream<Student> getStreamBuilderAccept() {
        Stream.Builder<Student> sb = Stream.builder();
        sb.accept(new Student("Dimebag", "Darrell", 27));
        sb.accept(new Student("Diana", "Krall", 23));
        sb.accept(new Student("Melody", "Gardot", 30));
        return sb.build();
    }

    public static Stream<Student> getStreamBuilderAdd() {
        Stream.Builder<Student> sb = Stream.builder();
        return sb
                .add(new Student("Dimebag", "Darrell", 27))
                .add(new Student("Diana", "Krall", 23))
                .add(new Student("Melody", "Gardot", 30))
                .build();
    }

    public static Stream<Student> getStreamOf() {
        return Stream.of(
                new Student("Dimebag", "Darrell", 27),
                new Student("Diana", "Krall", 23),
                new Student("Melody", "Gardot", 30));
    }

    public static Stream<Student> getStreamFromList() {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("John", "Doe", 28));
        l.add(new Student("Dimebag", "Darrell", 27));
        l.add(new Student("Gene", "Hoglan", 22));
        l.add(new Student("Tyler", "Durden", 26));
        l.add(new Student("Diana", "Krall", 23));
        l.add(new Student("Melody", "Gardot", 30));
        l.add(new Student("Tim", "Buckley", 21));
        return l.stream();
    }

    public static Stream<Student> getStreamFromArray() {
        Student[] l = new Student[3];
        l[0] = new Student("John", "Doe", 28);
        l[1] = new Student("Dimebag", "Darrell", 27);
        l[2] = new Student("Gene", "Hoglan", 22);
        return Arrays.stream(l);
    }
}
