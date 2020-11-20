package org.nbicocchi.collections.exercises.publication;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implement a class representing a Publication. Each publication has a title, a
 * publication date, and can cite other publications. Implement also two
 * subclasses Book and Magazine. A book has one additional ISBN code (13 digits
 * number), while a magazine has one additional progressive number representing
 * the issue. The written classes have to work with the following main()
 * method.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] x) {
        Publication book = new Book("The Art of Unix Programming", new GregorianCalendar(1990, Calendar.APRIL, 24),
                "978-3-16-148410-0");
        Publication magazine = new Magazine("Theoretical Computer Science", new GregorianCalendar(1995, Calendar.MAY, 13), 74);

        magazine.addReference(book);

        System.out.println(magazine);
        for (Publication p : magazine.getReferences())
            System.out.println(p);
    }
}