package org.nbicocchi.io;

import org.nbicocchi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Paths;

/**
 * A class showing how to use Reader and Writer interfaces
 *
 * @author Nicola Bicocchi
 */
public class ReaderWriter {
    static Logger logger = LoggerFactory.getLogger(ReaderWriter.class);

    /**
     * Copy chars from a generic reader to a generic writer
     */
    public static void copy(Reader r, Writer w, String fname, double size) throws IOException {
        int c;
        long begin, end;

        begin = System.nanoTime();
        while ((c = r.read()) != -1) {
            w.write(c);
        }
        end = System.nanoTime();
        logger.info(String.format("%s() [%.1fMB/S]", fname, size / ((end - begin) / 1000.0)));
    }

    public static void main(String[] args) throws IOException {
        String fin = Paths.get("src/main/resources/text/webpage.html").toString();
        String fout = Paths.get(Utils.ooprogrammingdir(), "webpage.html").toString();
        double size = new File(fin).length();

        try (Reader r = new FileReader(fin); Writer w = new FileWriter(fout)) {
            copy(r, w, "copy_no_buffer", size);
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_no_buffer"));
        }

        try (Reader r = new BufferedReader(new FileReader(fin)); Writer w = new BufferedWriter(new FileWriter(fout))) {
            copy(r, w, "copy_with_buffer", size);
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_with_buffer"));
        }

        try (Reader r = new BufferedReader(new FileReader(fin)); Writer w = new StringWriter()) {
            copy(r, w, "copy_to_stringwriter", size);
            // here w contains what has been read from r
        } catch (IOException e) {
            logger.info(String.format("%s failed", "copy_to_stringwriter"));
        }
    }

}
