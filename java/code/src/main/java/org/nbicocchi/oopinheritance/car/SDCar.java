package org.nbicocchi.oopinheritance.car;

public class SDCar extends Car {
    boolean isSelfDriving = false;

    public SDCar(String licensePlate) {
        super(licensePlate);
        System.out.println("new SDCar");
    }

    @Override
    void turnOn() {
        isSelfDriving = false;
        super.turnOn();
    }

    @Override
    void turnOff() {
        isSelfDriving = false;
        super.turnOff();
    }

    @Override
    public String toString() {
        return "SDCar [isSelfDriving=" + isSelfDriving + ", isOn=" + isOn + ", licensePlate=" + licensePlate + "]";
    }

    void turnSDOn() {
        isSelfDriving = true;
    }

    void turnSDOff() {
        isSelfDriving = false;
    }

}
