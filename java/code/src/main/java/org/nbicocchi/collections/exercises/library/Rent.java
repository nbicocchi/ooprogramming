package org.nbicocchi.collections.exercises.library;

import org.joda.time.DateTime;
import org.nbicocchi.utils.Student;

/**
 * Rent implements a rent of an Item to a Person for a delimited time frame
 */
public class Rent {
    Item item;
    Student student;
    DateTime begin;
    DateTime end;

    public Rent(Item item, Student student,
                DateTime begin, DateTime end) {
        this.item = item;
        this.student = student;
        this.begin = begin;
        this.end = end;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DateTime getBegin() {
        return begin;
    }

    public void setBegin(DateTime begin) {
        this.begin = begin;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public String toString() {
        return item + ", " + student + ", " + begin.toString() + ", " + end.toString();
    }
}
