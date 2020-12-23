package org.nbicocchi.oopinheritance.motorbike;

/**
 * A class representing a sold motor bike (circulating on the street)
 *
 * @author Nicola Bicocchi
 */
public class MotorbikeSold extends Motorbike {
    /**
     * The current speed of the motor bike, default is 0, it cannot exceed
     * maxspeed
     */
    double speed = 0.0;

    /**
     * Licence plate of the motorbike
     */
    String licencePlate = "JohnDoe";

    /**
     * Constructs a MotorbikeSold with the specified attributes
     *
     * @param brand        The brand of the motorbike
     * @param model        The model of the motorbike
     * @param maxspeed     The maximum speed of the motorbike
     * @param antitheft    True if anti-theft is installed
     * @param speed        The current speed of motorbike
     * @param licencePlate The licenceplate of motorbike
     */
    public MotorbikeSold(String brand, String model, double maxspeed, boolean antitheft, double speed,
                         String licencePlate) {
        super(brand, model, maxspeed, antitheft);
        this.speed = speed;
        this.licencePlate = licencePlate;
    }

    public MotorbikeSold(String brand, String model) {
        super(brand, model);
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set (not allowed to exceed maxspeed)
     */
    public void setSpeed(double speed) {
        this.speed = Math.min(maxspeed, speed);
    }

    /**
     * @return the licencePlate
     */
    public String getLicencePlate() {
        return licencePlate;
    }

    /**
     * @param licencePlate the licencePlate to set
     */
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "MotorbikeSold [speed=" + speed + ", licencePlate=" + licencePlate + ", brand=" + brand + ", model="
                + model + ", maxspeed=" + maxspeed + ", antitheft=" + antitheft + "]";
    }

}
