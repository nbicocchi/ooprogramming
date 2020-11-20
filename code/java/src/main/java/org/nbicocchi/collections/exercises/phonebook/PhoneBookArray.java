package org.nbicocchi.collections.exercises.phonebook;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;

/**
 * A PhoneBook implementation internally using ArrayList To be used for small
 * and simple applications. Slow!
 *
 * @author Nicola Bicocchi
 * @see PhoneBook
 */
public class PhoneBookArray implements PhoneBook {
    ArrayList<Student> pb;

    public PhoneBookArray() {
        pb = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        pb.add(p);
    }

    /**
     * Add a person to the PhoneBook
     *
     * @param name    Name of the person
     * @param surname Surname of the person
     * @param phone   Phone of the person
     */
    public void addPerson(String name, String surname, String phone) {
        pb.add(new Student(name, surname, phone));
    }

    @Override
    public Student searchByName(String name) {
        for (Student p : pb) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByLastname(String lastname) {
        for (Student p : pb) {
            if (p.getLastname().equals(lastname)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student p : pb) {
            if (p.getPhone().equals(phone)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteByNumber(String phone) {
        Student p = searchByNumber(phone);
        if (p != null)
            pb.remove(p);
    }
}
