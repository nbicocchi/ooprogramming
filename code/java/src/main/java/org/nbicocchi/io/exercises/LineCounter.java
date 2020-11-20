package org.nbicocchi.io.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a program for reading a text file and counting the total number of both
 * lines and chars. The program should output two lines as per below: lines: x
 * chars: y
 *
 * @author Nicola Bicocchi
 */
public class LineCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        String s;
        int lines = 0;
        int chars = 0;

        try {
            in = new BufferedReader(new FileReader("src/main/resources/text/webpage.html"));
            while ((s = in.readLine()) != null) {
                chars += s.length();
                lines++;
            }
            System.out.println("lines: " + lines);
            System.out.println("chars: " + chars);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
