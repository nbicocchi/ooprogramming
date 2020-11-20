package org.nbicocchi.collections.exercises.library;

/**
 * Class representing a Book
 */
public class Book extends Item {
    int pages;

    public Book(String title, int year, int pages) {
        super(title, year);
        this.pages = pages;
    }
}
