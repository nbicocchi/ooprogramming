package org.nbicocchi.collections.exercises.publication;

import java.util.GregorianCalendar;

/**
 * A class representing a Book
 *
 * @author Nicola Bicocchi
 */
public class Book extends Publication {
    String ISBN;

    /**
     * @param title   Title of the book
     * @param pubDate Publication date of the book
     * @param ISBN    ISBN Code of the book
     */
    public Book(String title, GregorianCalendar pubDate, String ISBN) {
        super(title, pubDate);
        this.ISBN = ISBN;
    }
}
