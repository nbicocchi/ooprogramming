package org.nbicocchi.basics;

import java.util.Arrays;

/**
 * Implement a Bubble Sort algorithm for sorting arrays of integer numbers
 *
 * @author Nicola Bicocchi
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] v = {17, 21, 83, 14, 35, 69, 51, 33, 62};

        System.out.println(Arrays.toString(v));
        bubbleSort(v);
        System.out.println(Arrays.toString(v));
    }

    static void bubbleSort(int[] v) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    changed = true;
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                }
            }
        }
    }
}
