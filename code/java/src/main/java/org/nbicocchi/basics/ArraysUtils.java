package org.nbicocchi.basics;

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of using the java.util.Arrays class and the System.arraycopy()
 * method
 */
public class ArraysUtils {
    public static void main(String[] main) {
        int[] v1 = new int[8];
        int[] v2 = new int[8];
        Random rnd = new Random();

        Arrays.fill(v1, rnd.nextInt(100));
        System.out.println("v1 = " + Arrays.toString(v1));

        for (int i = 0; i < v1.length; i++) {
            v1[i] = rnd.nextInt(100);
        }
        System.out.println("v1 = " + Arrays.toString(v1));

        Arrays.sort(v1);
        System.out.println("v1 = " + Arrays.toString(v1));

        System.arraycopy(v1, 0, v2, 0, 5);
        System.out.println("v2 = " + Arrays.toString(v2));
    }
}
