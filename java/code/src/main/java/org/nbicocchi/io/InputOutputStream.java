package org.nbicocchi.io;

import org.nbicocchi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Paths;

/**
 * A class showing how to use InputStream and OutputStream interfaces
 *
 * @author Nicola Bicocchi
 */
public class InputOutputStream {
    static Logger logger = LoggerFactory.getLogger(InputOutputStream.class);

    public static void main(String[] args) {
        String fin = Paths.get("src/main/resources/images/shuttle.jpg").toString();
        String fout = Paths.get(Utils.ooprogrammingdir(), "shuttle.jpg").toString();
        double size = new File(fin).length();

        try (InputStream r = new FileInputStream(fin); OutputStream w = new FileOutputStream(fout)) {
            copy(r, w, "copy_no_buffer", size);
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_no_buffer"));
        }

        try (InputStream r = new BufferedInputStream(new FileInputStream(fin));
             OutputStream w = new BufferedOutputStream(new FileOutputStream(fout))) {
            copy(r, w, "copy_with_buffer", size);
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_with_buffer"));
        }

        try (InputStream r = new BufferedInputStream(new FileInputStream(fin));
             OutputStream w = new ByteArrayOutputStream()) {
            copy(r, w, "copy_to_bytearray", size);
            // here w contains what has been read from r
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_to_bytearray"));
        }

        try (InputStream r = new FileInputStream(fin); OutputStream w = new FileOutputStream(fout)) {
            copySinglePass(r, w, "copy_single_pass", size);
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_single_pass"));
        }
    }

    /**
     * Copy chars from a generic inputstream to a generic outputstream
     */
    public static void copy(InputStream r, OutputStream w, String filename, double size) throws IOException {
        int c;
        long begin, end;

        begin = System.nanoTime();
        while ((c = r.read()) != -1) {
            w.write(c);
        }
        end = System.nanoTime();
        logger.info(String.format("%s() [%.1fMB/S]", filename, size / ((end - begin) / 1000.0)));
    }

    /**
     * Copy chars from a generic inputstream to a generic outputstream in a
     * single pass
     */
    public static void copySinglePass(InputStream r, OutputStream w, String filename, double size) throws IOException {
        byte[] buffer = new byte[(int) size];
        long begin, end;

        begin = System.nanoTime();
        r.read(buffer);
        w.write(buffer);
        end = System.nanoTime();
        logger.info(String.format("%s() [%.1fMB/S]", filename, size / ((end - begin) / 1000.0)));
    }
}