package org.nbicocchi.io;

import java.util.StringTokenizer;

/**
 * Class showing how to use the StringTokenizer class
 */
public class Tokenizer {
    public static void main(String[] args) {
        String str = "This is a String , split by StringTokenizer, created by Nicola";

        StringTokenizer st = new StringTokenizer(str);
        System.out.println("---- Split by space ------");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }

        StringTokenizer st2 = new StringTokenizer(str, ",");
        System.out.println("---- Split by comma ',' ------");
        while (st2.hasMoreElements()) {
            System.out.println(st2.nextElement());
        }
    }
}
