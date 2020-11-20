package org.nbicocchi.collections.exercises.library;

/**
 * Class generalizing Books and DVDs
 */
public class Item {
    String title;
    int year;

    public Item(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String toString() {
        return title + " (" + year + ")";
    }
}
