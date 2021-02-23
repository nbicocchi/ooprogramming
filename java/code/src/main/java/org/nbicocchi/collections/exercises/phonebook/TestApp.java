package org.nbicocchi.collections.exercises.phonebook;

import org.nbicocchi.utils.Student;

/**
 * The PhoneBook Interface defines the functionalities of a basic phone book.
 * <p>
 * Provide two different implementations of the given interface working with the
 * use case below. The first, using internally Arraylist (a), the second using
 * internally HashMap (b).
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBookMap();
        //PhoneBook pb = new PhoneBookArray();
        pb.addPerson(new Student("Nicola", "Bicocchi", "34567"));
        pb.addPerson(new Student("Marco", "Rizzo", "45243"));
        pb.addPerson(new Student("Luisa", "Poppi", "24564"));

        System.out.println(pb.searchByName("Marco"));
        System.out.println(pb.searchByLastname("Poppi"));

        // do not exist!
        System.out.println(pb.searchByNumber("1111"));

        // delete an element!
        pb.deleteByNumber("24564");
        System.out.println(pb.searchByLastname("Poppi"));
    }
}
