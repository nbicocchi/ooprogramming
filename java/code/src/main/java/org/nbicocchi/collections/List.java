package org.nbicocchi.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Class showing how to use basic list methods
 *
 * @author Nicola Bicocchi
 */
public class List {
    public static void main(String[] args) {
        String action;
        java.util.List<Integer> l = new ArrayList<>();
        // List<Integer> l = new LinkedList<Integer>();

        action = "Adding elements...";
        System.out.println(action);
        l.add(2);
        l.add(14);
        l.add(3);
        l.add(7);

        action = "Adding element at specific position (position, value)...";
        System.out.println(action);
        l.add(1, 17);

        action = "Getting an element...";
        System.out.println(action);
        System.out.println(l.get(0));
        System.out.println(l.get(1));

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }

        action = "Removing an element by index...";
        System.out.println(action);
        l.remove(1);

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }

        action = "Check if contains an element...";
        System.out.println(action);
        System.out.println(l.contains(3));

        action = "Get size...";
        System.out.println(action);
        System.out.println(l.size());

        action = "Sorting...";
        System.out.println(action);
        Collections.sort(l);

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }

        action = "Removing an element while iterating...";
        System.out.println(action);
        for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
            int n = i.next();
            if (n == 14)
                i.remove();
        }

        action = "Adding an element while iterating...";
        System.out.println(action);
        for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
            int n = i.next();
            if (n == 3)
                i.add(44);
        }

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }
    }

}
