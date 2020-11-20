package org.nbicocchi.io;

import java.io.File;

public class Separators {
    public static void main(String[] args) {
        System.out.println(
                File.pathSeparator + " " +
                        File.pathSeparatorChar + " " +
                        File.separator + " " +
                        File.separatorChar + " " +
                        // ... or using System...
                        System.getProperty("path.separator") + " " +
                        System.getProperty("file.separator")
        );
    }
}
