package org.nbicocchi.collections.exercises.library;

import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.nbicocchi.utils.Student;

import java.util.ArrayList;

public class Library {
    ArrayList<Rent> rents;

    public Library() {
        rents = load();
        System.out.println("- All Rents:");
        for (Rent r : rents) {
            System.out.println(r);
        }

        System.out.println("- Longest Rent:");
        System.out.println(getLongestRent());

        System.out.println("- Faulty Rents:");
        for (Rent r : getFaults()) {
            System.out.println(r);
        }

    }

    private ArrayList<Rent> load() {
        ArrayList<Rent> r = new ArrayList<>();
        DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy");

        Student student1 = new Student("0001", "Darrell", "Abbott");
        Student student2 = new Student("0002", "Nick", "Drake");

        Item i1 = new Book("Soffocare", 2002, 170);
        Item i2 = new Dvd("Moon", 2011, 130);

        r.add(new Rent(i1, student1, f.parseDateTime("15/06/2020"), f.parseDateTime("15/07/2020")));
        r.add(new Rent(i1, student2, f.parseDateTime("10/07/2020"), f.parseDateTime("20/07/2020")));
        r.add(new Rent(i1, student1, f.parseDateTime("25/08/2020"), f.parseDateTime("14/09/2020")));

        r.add(new Rent(i2, student2, f.parseDateTime("10/07/2020"), f.parseDateTime("20/07/2020")));
        r.add(new Rent(i2, student1, f.parseDateTime("25/08/2020"), f.parseDateTime("14/10/2020")));

        return r;
    }

    private Rent getLongestRent() {
        Rent longestRent = rents.get(0);

        for (Rent r : rents) {
            if ((r.getEnd().getMillis() - r.getBegin().getMillis()) >
                    (longestRent.getEnd().getMillis() - longestRent.getBegin().getMillis())) {
                longestRent = r;
            }
        }
        return longestRent;
    }

    private ArrayList<Rent> getFaults() {
        ArrayList<Rent> r = new ArrayList<>();
        for (int i = 0; i < rents.size() - 1; i++) {
            for (int j = i + 1; j < rents.size(); j++) {
                Rent r1 = rents.get(i);
                Rent r2 = rents.get(j);
                Interval i1 = new Interval(r1.getBegin(), r1.getEnd());
                Interval i2 = new Interval(r2.getBegin(), r2.getEnd());
                if (i2.overlaps(i1) && r1.getItem() == r2.getItem()) {
                    r.add(rents.get(i));
                    r.add(rents.get(j));
                }
            }
        }
        return r;
    }
}
