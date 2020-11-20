package org.nbicocchi.collections.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a class named Statistics for calculating min, max, average, and median
 * of a collection of elements. Please refer to the use case in main() method
 * below.
 *
 * @author Nicola Bicocchi
 */
public class Statistics {
    List<Double> l;

    public Statistics() {
        l = new ArrayList<>();
    }

    public static void main(String[] x) {
        Statistics s = new Statistics();
        s.add(5.0);
        s.add(10.0);
        s.add(70.0);

        System.out.printf("min=%.2f\n", s.min());
        System.out.printf("max=%.2f\n", s.max());
        System.out.printf("average=%.2f\n", s.average());
        System.out.printf("median=%.2f\n", s.median());
        System.out.printf("elements: %s\n", s.elements().toString());
    }

    public void add(Double n) {
        l.add(n);
    }

    public double min() {
        double min = l.get(0);
        for (double n : l)
            if (n < min)
                min = n;
        return min;
    }

    public double max() {
        double max = l.get(0);
        for (double n : l)
            if (n > max)
                max = n;
        return max;
    }

    public double average() {
        double sum = 0;
        for (double n : l)
            sum += n;
        return sum / l.size();
    }

    public double median() {
        int middle = l.size() / 2;
        if (l.size() % 2 == 1) {
            return l.get(middle);
        } else {
            return (l.get(middle - 1) + l.get(middle)) / 2.0;
        }
    }

    public List<Double> elements() {
        return l;
    }
}
