package org.nbicocchi.oop;

import java.util.Arrays;

/**
 * Implementare una classe StringProcessor per effettuare operazioni su array di
 * stringhe. Metodi:
 * <p>
 * public StringProcessor(String[] v): Costruttore
 * <p>
 * public int findShortest(): ritorna l'indice della stringa più corta contenuta
 * nello StringProcessor
 * <p>
 * public int search(String key): ritorna l'indice dell'elemento key all'interno
 * dello StringProcessor. -1 se non trovato.
 * <p>
 * public void reverse(): capovolge l'ordine delle stringhe contenute nello
 * StringProcessor.
 * <p>
 * public boolean equals(Object obj)
 *
 * @author Nicola Bicocchi
 */
public class StringProcessor {
    String[] v;

    public StringProcessor(String[] v) {
        super();
        this.v = v;
    }

    public static void main(String[] args) {
        String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
        String[] v2 = {"Nicola", "Marzia", "Agata", "Dharma"};
        StringProcessor sp1 = new StringProcessor(v1);
        StringProcessor sp2 = new StringProcessor(v2);

        System.out.println("shortest=" + sp1.findShortest());
        System.out.println("search=" + sp1.search("Marzia"));
        sp1.reverse();
        // False because sp1 has been reversed
        System.out.println("equals=" + sp1.equals(sp2));
    }

    public int findShortest() {
        int min_pos = 0;
        int min_length = 128;
        for (int i = 0; i < v.length; i++) {
            if (v[i].length() < min_length) {
                min_pos = i;
                min_length = v[i].length();
            }
        }
        return min_pos;
    }

    public int search(String key) {
        int i;

        for (i = 0; i < v.length; i++) {
            if (v[i].equals(key))
                return i;
        }
        return -1;
    }

    public void reverse() {
        for (int i = 0; i < v.length / 2; i++) {
            String tmp = v[i];
            v[i] = v[v.length - 1 - i];
            v[v.length - 1 - i] = tmp;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringProcessor other = (StringProcessor) obj;
        return Arrays.equals(v, other.v);
    }
}
