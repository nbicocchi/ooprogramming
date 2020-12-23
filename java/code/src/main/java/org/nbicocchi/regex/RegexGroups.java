package org.nbicocchi.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroups {
    public static void main(String[] args) {
        // String to be scanned to find the pattern.
        String line = "Ordered 3000 items having code ABCD.";
        String pattern = "(\\d+) items (.*) code (\\S+).";

        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = p.matcher(line);

        if (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.printf("group=%d, value=%s\n", i, m.group(i));
            }
        } else {
            System.out.println("[no match]");
        }
    }
}
