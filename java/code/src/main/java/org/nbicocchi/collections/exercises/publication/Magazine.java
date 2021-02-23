package org.nbicocchi.collections.exercises.publication;

import java.util.GregorianCalendar;

/**
 * A class representing a Magazine
 *
 * @author Nicola Bicocchi
 */
public class Magazine extends Publication {
    int issue;

    /**
     * @param title   Title of the Magazine
     * @param pubDate Publication Date
     * @param issue   Issue number
     */
    public Magazine(String title, GregorianCalendar pubDate, int issue) {
        super(title, pubDate);
        this.issue = issue;
    }

}
