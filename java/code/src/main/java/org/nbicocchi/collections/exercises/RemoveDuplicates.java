package org.nbicocchi.collections.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a class with a static method capable of receiving a List and removing
 * duplicates. Refer to the main() below as a use case.
 *
 * @author Nicola Bicocchi
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Number> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(3);

        System.out.println(l);
        removeDuplicates(l);
        System.out.println(l);
    }

    /**
     * Removes duplicates from a list using HashSets (long version)
     *
     * @param l list in which duplicates have to be removed
     */
    public static void removeDuplicates(List<Number> l) {
        Set<Number> s = new HashSet<>(l);
        l.clear();
        l.addAll(s);
    }

}
