package org.nbicocchi.collections;

import java.util.LinkedList;

/**
 * Class showing how to use basic queue methods
 *
 * @author Nicola Bicocchi
 */
public class Queue {
    public static void main(String[] args) {
        String act;
        java.util.Queue<Integer> l = new LinkedList<>();
        // java.util.Queue<Integer> l = new PriorityQueue<Integer>();

        act = "Adding elements...";
        System.out.println(act);
        l.add(2);
        l.add(14);
        l.add(3);
        l.add(7);

        act = "Showing content...";
        System.out.println(act);
        for (int i : l) {
            System.out.println(i);
        }

        act = "Peek element...";
        System.out.println(act);
        System.out.println(l.peek());

        act = "Peek element...";
        System.out.println(act);
        System.out.println(l.peek());

        act = "Poll element...";
        System.out.println(act);
        System.out.println(l.poll());

        act = "Showing content...";
        System.out.println(act);
        for (int i : l) {
            System.out.println(i);
        }
    }
}
