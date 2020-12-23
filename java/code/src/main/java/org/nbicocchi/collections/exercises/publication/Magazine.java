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
     * @param title
     * @param pubDate
     * @param issue
     */
    public Magazine(String title, GregorianCalendar pubDate, int issue) {
        super(title, pubDate);
        this.issue = issue;
    }


}
