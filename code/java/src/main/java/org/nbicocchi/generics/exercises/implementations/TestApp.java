package org.nbicocchi.generics.exercises.implementations;

import org.nbicocchi.utils.Student;

/**
 * Data l'implementazione semplificata di ArrayList e LinkedList (package
 * Collections->Implementations), renderle generiche (ArrayList<T>,
 * LinkedList<T>)in modo da applicarsi al caso d'uso seguente.
 *
 * @author Nicola Bicocchi
 * @see GenericList
 */
public class TestApp {
    public static void main(String[] args) {
        GenericList<Student> l;
        l = new GenericArrayList<>();
        // l = new GenericLinkedList<Student>();
        l.add(new Student("Padre", "Maronno", 28.4));
        l.add(new Student("Anna", "Pannocchia", 26.3));
        l.add(new Student("Maccio", "Capatonda", 29.4));
        l.add(new Student("Herbert", "Ballerina", 29.4), 1);

        l.remove(3);
        System.out.println("size=" + l.size());
        System.out.println(l);
    }

}
