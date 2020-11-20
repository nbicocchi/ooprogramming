package org.nbicocchi.basics;

/**
 * Write a program for composing a String using StringBuilder
 *
 * @author Nicola Bicocchi
 */
public class StringComposition {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};

        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }

        System.out.println(sb.toString());
    }

}
