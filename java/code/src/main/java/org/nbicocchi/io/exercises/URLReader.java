package org.nbicocchi.io.exercises;

import org.nbicocchi.utils.Utils;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Java URL contiene un metodo openStream() che ritorna un InputStream
 * collegato alla pagina indicata al costruttore di URL. Ad esempio new
 * URL("http://www.google.it").openStream() ritorna un InputStream.
 * <p>
 * Costruire una classe URLReader che funzioni con il main sottostante in grado
 * di leggere una pagina web, memorizzarla, ed eventualmente salvarla su un file
 * di testo.
 * <p>
 * Per utilizzare BufferedReader (stream di testo) con dati provenienti da un
 * InputStream (stream binario) utilizzare la classe InputStreamReader per
 * effettuare la conversione.
 *
 * @author Nicola Bicocchi
 */
public class URLReader {
    List<String> lastPage;
    String lastURL = null;

    public URLReader() {
        lastPage = new ArrayList<>();
    }

    public static void main(String[] args) {
        URLReader ur = new URLReader();
        try {
            System.out.println("Downloading page...");
            ur.readPage("http://www.google.it");

            System.out.println("Saving page...");
            ur.savePage(Paths.get(Utils.ooprogrammingdir(), "www.google.it.html").toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with I/O...");
        }

    }

    public void readPage(String urlname) throws IOException {
        URL url = new URL(urlname);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        lastURL = urlname;
        lastPage.clear();

        String line;
        while ((line = in.readLine()) != null)
            lastPage.add(line);

        in.close();
    }

    public void savePage(String filename) throws IOException {
        if (lastPage.isEmpty())
            return;
        PrintWriter out = new PrintWriter(new FileWriter(filename));

        for (String l : lastPage) {
            out.println(l);
        }

        out.close();
    }
}
