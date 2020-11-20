package org.nbicocchi.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

/**
 * A class showing random access capabilities on files
 *
 * @author Nicola Bicocchi
 */
public class RandomAccess {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(Paths.get("src/main/resources/text/webpage.html").toFile(), "r");
        byte[] buffer = new byte[1024];

        // skip first 1024 bytes (random access!)
        file.seek(1024);

        // read 1024 bytes
        file.read(buffer);

        // close file
        file.close();

        System.out.println(new String(buffer));
    }
}