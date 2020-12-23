package org.nbicocchi.jdbc.coursemanager;


import java.util.Date;
import java.util.UUID;

public class Student {
    private UUID ID;
    private String name;
    private String surname;
    private Date birthDate;

    public Student(UUID ID, String name, String surname, Date birthDate) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID.toString() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
