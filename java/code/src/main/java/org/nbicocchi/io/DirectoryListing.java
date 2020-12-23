package org.nbicocchi.io;

import java.io.File;
import java.io.IOException;

/**
 * Class for listing the content of a directory
 *
 * @author Nicola Bicocchi
 */
public class DirectoryListing {
    public static void main(String[] args) throws IOException {
        File path = new File(System.getProperty("user.home"));
        if (!path.isDirectory())
            throw new IOException();

        File[] l = path.listFiles();

        /* this code block allows filtering */
//		List<File> l = Arrays.asList(path.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String file) {
//				return file.endsWith(".pdf");
//			}
//		}));

        if (l != null) {
            for (File f : l) {
                System.out.println(f);
            }
        }
    }

}