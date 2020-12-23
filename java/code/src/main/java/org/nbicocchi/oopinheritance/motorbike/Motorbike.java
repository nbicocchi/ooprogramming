package org.nbicocchi.oopinheritance.motorbike;

/**
 * A class representing a brand new motorbike
 *
 * @author Nicola Bicocchi
 */
public class Motorbike {
    /**
     * The brand of the motorbike
     */
    String brand;

    /**
     * The model of the motorbike
     */
    String model;

    /**
     * The maximum speed of the motorbike, default is 180
     */
    double maxspeed = 200;

    /**
     * True if an anti-theft system is installed on the motorbike, default is
     * false
     */
    boolean antitheft = false;

    /**
     * Constructs a Motorbike with the specified attributes
     *
     * @param brand     The brand of the motor bike
     * @param model     The model of the motor bike
     * @param maxspeed  The maximum speed of the motor bike
     * @param antitheft True if anti-theft is installed
     */
    public Motorbike(String brand, String model, double maxspeed, boolean antitheft) {
        super();
        this.brand = brand;
        this.model = model;
        this.maxspeed = maxspeed;
        this.antitheft = antitheft;
    }

    public Motorbike(String brand, String model) {
        super();
        this.brand = brand;
        this.model = model;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the maxspeed
     */
    public double getMaxspeed() {
        return maxspeed;
    }

    /**
     * @param maxspeed the maxspeed to set
     */
    public void setMaxspeed(double maxspeed) {
        this.maxspeed = maxspeed;
    }

    /**
     * @return the antitheft
     */
    public boolean isAntitheft() {
        return antitheft;
    }

    /**
     * @param antitheft the antitheft to set
     */
    public void setAntitheft(boolean antitheft) {
        this.antitheft = antitheft;
    }

    @Override
    public String toString() {
        return "Motorbike [brand=" + brand + ", model=" + model + ", maxspeed=" + maxspeed + ", antitheft=" + antitheft
                + "]";
    }
}
