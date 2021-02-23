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
public class PhoneBookMap implements PhoneBook {
    HashMap<String, Student> map;

    public PhoneBookMap() {
        map = new HashMap<>();
    }

    // We use the phone number as key because it is unique
    public void addPerson(Student s) {
        map.put(s.getPhone(), s);
    }

    public Student searchByName(String name) {
        for (Student s : map.values()) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByLastname(String lastname) {
        for (Student s : map.values()) {
            if (s.getLastname().equals(lastname)) {
                return s;
            }
        }
        return null;
    }

    public Student searchByNumber(String phone) {
        if (map.containsKey(phone)) {
            return map.get(phone);
        }
        return null;
    }

    public void deleteByNumber(String phone) {
        map.remove(phone);
    }
}
