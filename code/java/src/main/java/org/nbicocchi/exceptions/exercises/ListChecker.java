package org.nbicocchi.exceptions.exercises;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Use the StringChecker class and Iterators for removing invalid elements from
 * a List of Strings while iterating over it.
 *
 * @author Nicola Bicocchi
 */
public class ListChecker {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("rrr6t8f0d0e");
        l.add("r5r6t8f0d0e");
        l.add("r2r6t8f0d00");
        l.add("z1z0t8f1d7d");

        StringChecker sc = new StringChecker();
        for (Iterator<String> i = l.iterator(); i.hasNext(); ) {
            String s = i.next();
            try {
                System.out.printf("Checking %s ", s);
                sc.check(s);
                System.out.println("[PASS]");
            } catch (ParseException e) {
                i.remove();
                System.out.println("[FAIL]");
            }
        }

        for (String s : l) {
            System.out.println(s);
        }
    }
}
