package org.nbicocchi.collections;

import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * Class for showing the speed of insertion and retrieval from ArrayList,
 * LinkedList, HashMap
 *
 * @author Nicola Bicocchi
 */
public class SpeedTest {
    int items;
    long start;
    long stop;
    Random rnd;

    public SpeedTest(int items) {
        this.items = items;
        this.rnd = new Random();
    }

    public long fillList(List<Integer> l) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            l.add(rnd.nextInt(items));
        }
        stop = System.nanoTime();
        return stop - start;
    }

    public void retrieveValueFromList(List<Integer> l, int value) {
        for (Integer integer : l) {
            if (integer.equals(value))
                break;
        }
    }

    public long retrieveFromList(List<Integer> l) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            retrieveValueFromList(l, rnd.nextInt(items));
        }
        stop = System.nanoTime();
        return stop - start;
    }

    public long fillMap(Map<Integer, Integer> m) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            int n = rnd.nextInt(items);
            m.put(n, n);
        }
        stop = System.nanoTime();
        return stop - start;
    }

    public long retrieveFromMap(Map<Integer, Integer> m) {
        start = System.nanoTime();
        for (int i = 0; i < items; i++) {
            m.get(rnd.nextInt(items));
        }
        stop = System.nanoTime();
        return stop - start;
    }

    public static void main(String[] args) {
        long t;
        int items = 3000;
        SpeedTest test = new SpeedTest(items);

        ArrayList<Integer> al = new ArrayList<>();
        t = test.fillList(al);
        System.out.println("Filling ArrayList [items=" + items + "][time=" + t / 1000000.0 + "ms]");

        t = test.retrieveFromList(al);
        System.out.println("Retrieving ArrayList [items=" + items + "][time=" + t / 1000000.0 + "ms]");

        LinkedList<Integer> ll = new LinkedList<>();
        t = test.fillList(ll);
        System.out.println("Filling LinkedList [items=" + items + "][time=" + t / 1000000.0 + "ms]");

        t = test.retrieveFromList(ll);
        System.out.println("Retrieving LinkedList [items=" + items + "][time=" + t / 1000000.0 + "ms]");

        HashMap<Integer, Integer> m = new HashMap<>();
        t = test.fillMap(m);
        System.out.println("Filling HashMap [items=" + items + "][time=" + t / 1000000.0 + "ms]");

        t = test.retrieveFromMap(m);
        System.out.println("Retrieving HashMap [items=" + items + "][time=" + t / 1000000.0 + "ms]");

    }
}
