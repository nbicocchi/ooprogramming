package org.nbicocchi.collections.exercises.library;

/**
 * Class representing a DVD
 */
public class Dvd extends Item {
    int duration;

    public Dvd(String title, int year, int duration) {
        super(title, year);
        this.duration = duration;
    }
}