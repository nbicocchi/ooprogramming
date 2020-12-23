package org.nbicocchi.collections.exercises.publication;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Class representing a publication
 *
 * @author Nicola Bicocchi
 */
public abstract class Publication {
    String title;
    GregorianCalendar pubDate;
    List<Publication> references;

    /**
     * @param title   Title of the publications
     * @param pubDate Publication date
     */
    public Publication(String title, GregorianCalendar pubDate) {
        this.title = title;
        this.pubDate = pubDate;
        references = new ArrayList<>();
    }

    /**
     * @param p A reference to be added to the bibliography
     */
    public void addReference(Publication p) {
        references.add(p);
    }

    /**
     * @return A List of publications (bibliography)
     */
    public List<Publication> getReferences() {
        return references;
    }

    @Override
    public String toString() {
        return "Publication [title=" + title + "]";
    }
}
