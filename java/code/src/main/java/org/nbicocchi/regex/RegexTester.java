package org.nbicocchi.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexTester {

    public static void process(String line) {
        if (line.isBlank()) {
            return;
        }

        if (line.startsWith("#")) {
            System.out.println("\n" + line);
            return;
        }

        String[] v = line.split(", ");

        String pattern = v[0].substring(1, v[0].length() - 1);
        String test = v[1].substring(1, v[1].length() - 1);
        boolean result = Pattern.matches(pattern, test);

        System.out.printf("[%b] regex=%s test=%s\n", result, pattern, test);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/main/resources/text/regex_examples.csv"))) {
            while (scanner.hasNextLine()) {
                process(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
