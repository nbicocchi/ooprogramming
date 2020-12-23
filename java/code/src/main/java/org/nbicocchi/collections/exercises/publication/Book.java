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
     * @param title
     * @param pubDate
     * @param ISBN
     */
    public Book(String title, GregorianCalendar pubDate, String ISBN) {
        super(title, pubDate);
        this.ISBN = ISBN;
    }
}
