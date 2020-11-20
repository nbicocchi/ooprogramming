package org.nbicocchi.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasics {
    public static void main(String[] args) {
        boolean b;

        // 1st way
        Pattern p = Pattern.compile(".s");//. represents single character
        Matcher m = p.matcher("as");
        b = m.matches();
        System.out.println(b);

        // 2nd way
        b = Pattern.compile(".s").matcher("as").matches();
        System.out.println(b);

        // 3rd way
        b = Pattern.matches(".s", "as");
        System.out.println(b);

        // 4th way
        b = "as".matches(".s");
        System.out.println(b);
    }
}
