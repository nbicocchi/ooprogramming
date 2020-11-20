package org.nbicocchi.jdbc.coursemanager;


import java.util.UUID;

public class Course {
    private UUID ID;
    private String name;
    private int teachers;
    private int cfu;

    public Course(UUID ID, String name, int teachers, int cfu) {
        this.ID = ID;
        this.name = name;
        this.teachers = teachers;
        this.cfu = cfu;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeachers() {
        return teachers;
    }

    public void setTeachers(int teachers) {
        this.teachers = teachers;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                ", cfu=" + cfu +
                '}';
    }
}
