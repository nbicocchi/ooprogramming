package org.nbicocchi.generics.exercises;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Costruire una classe di utilità (Utils) composta da tre metodi statici in
 * grado di manipolare liste di elementi generici.
 * <p>
 * swap(List<E> l, int i, int j): scambia gli elementi agli indici i e j di
 * posto (sulla lista l)
 * <p>
 * bubbleSort(List<E> l): esegue un ordinamento bubble sort sulla lista l
 * <p>
 * print(List<E> l): ritorno una rappresentazione in stringa della lista
 * <p>
 * Il codice prodotto va applicato al seguente caso di studio
 *
 * @author Nicola Bicocchi
 */
public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Double> l = new ArrayList<>();
        l.add(2.0);
        l.add(7.0);
        l.add(1.0);
        l.add(5.0);

        swap(l, 0, 3);
        print(l);

        bubbleSort(l);
        print(l);

        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student("Nicola", "Bicocchi", 24.6));
        s.add(new Student("Lucia", "Rossi", 28.5));
        s.add(new Student("Maccio", "Capatonda", 23.9));

        print(s);
        bubbleSort(s);
        System.out.println(print(s));
    }

    public static <T> void swap(List<T> l, int i, int j) {
        T c = l.get(i);
        l.set(i, l.get(j));
        l.set(j, c);
    }

    public static <T> String print(List<T> l) {
        StringBuilder sb = new StringBuilder();
        for (T e : l) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> l) {
        boolean ordered = false;
        while (!ordered) {
            ordered = true;
            for (int i = 1; i < l.size(); i++) {
                if (l.get(i - 1).compareTo(l.get(i)) > 0) {
                    ordered = false;
                    swap(l, i, i - 1);
                }
            }
        }
    }

}
