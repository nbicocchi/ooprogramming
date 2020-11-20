package org.nbicocchi.collections.exercises.phonebook;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A PhoneBook implementation internally using HashMap
 *
 * @author Nicola Bicocchi
 * @see PhoneBook
 */
public class PhoneBookHash implements PhoneBook {
    ArrayList<Student> pb;
    HashMap<String, Student> indexName;
    HashMap<String, Student> indexSurname;
    HashMap<String, Student> indexNumber;

    public PhoneBookHash() {
        pb = new ArrayList<>();
        indexName = new HashMap<>();
        indexSurname = new HashMap<>();
        indexNumber = new HashMap<>();
    }

    public void addPerson(Student p) {
        pb.add(p);
        indexName.put(p.getName(), p);
        indexSurname.put(p.getLastname(), p);
        indexNumber.put(p.getPhone(), p);
    }

    public Student searchByName(String name) {
        if (indexName.containsKey(name)) {
            return indexName.get(name);
        }
        return null;
    }

    public Student searchByLastname(String lastname) {
        if (indexSurname.containsKey(lastname)) {
            return indexSurname.get(lastname);
        }
        return null;
    }

    public Student searchByNumber(String phone) {
        if (indexNumber.containsKey(phone)) {
            return indexNumber.get(phone);
        }
        return null;
    }

    public void deleteByNumber(String phone) {
        if (indexNumber.containsKey(phone)) {
            Student p = indexNumber.get(phone);

            indexName.remove(p.getName());
            indexSurname.remove(p.getLastname());
            indexNumber.remove(p.getPhone());

            pb.remove(p);
        }
    }
}
