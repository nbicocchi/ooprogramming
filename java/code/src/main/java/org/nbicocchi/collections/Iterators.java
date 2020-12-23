package org.nbicocchi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class showing how to use the for cycles for iterating collections and
 * iterators for modifying collections while iterating
 *
 * @author Nicola Bicocchi
 */
public class Iterators {
    public static void main(String[] args) {
        // list instantiation and filling
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        // C-like syntax
        System.out.println("List Content:");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

        // for-each syntax
        System.out.println("List Content:");
        for (int i : l) {
            System.out.println(i);
        }

        // iterator-based syntax
        System.out.println("List Content:");
        for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }

        // remove an element from a list using removeIf (lambda expression and Predicate)
        l.removeIf(n -> (n == 5));

        // remove an element from a list using Iterators
        for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
            int n = i.next();
            if (n == 2)
                i.remove();
        }

        // add an element in a list using ListIterators
        for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
            int n = i.next();
            if (n == 1)
                i.add(17);
        }

        // show content of the list
        System.out.println("List Content:");
        for (int i : l) {
            System.out.println(i);
        }

    }
}
