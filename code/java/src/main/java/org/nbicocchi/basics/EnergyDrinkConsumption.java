package org.nbicocchi.basics;

/**
 * A soft drink company recently surveyed 12,467 of its customers and found that
 * approximately 14 percent of those surveyed purchase one or more energy drinks
 * per week. Of those customers who purchase energy drinks, approximately 64
 * percent of them prefer citrus flavored energy drinks. Write a program that
 * displays the following:
 * <p>
 * The approximate number of customers in the survey who purchased one or more
 * energy drinks per week
 * <p>
 * The approximate number of customers in the survey who prefer citrus flavored
 * energy drinks
 *
 * @author Justin Musgrove
 */
public class EnergyDrinkConsumption {

    // constants
    final static int NUMBERED_SURVEYED = 12467;
    final static double PURCHASED_ENERGY_DRINKS = 0.14;
    final static double PREFER_CITRUS_DRINKS = 0.64;

    public static void main(String[] args) {

        // Variables
        double energyDrinkers = (NUMBERED_SURVEYED * PURCHASED_ENERGY_DRINKS);
        double preferCitrus = (NUMBERED_SURVEYED * PREFER_CITRUS_DRINKS);

        // Display the results.
        System.out.println("Total number of people surveyed " + NUMBERED_SURVEYED);
        System.out.println("Approximately " + energyDrinkers + " bought at least one energy drink");
        System.out.println(preferCitrus + " of those " + "prefer citrus flavored energy drinks.");
    }

}
