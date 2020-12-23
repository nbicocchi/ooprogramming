package org.nbicocchi.oopinheritance.car;

public class Car {
    boolean isOn = false;
    String licensePlate = "JohnDoe";

    public Car() {

    }

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        System.out.println("new Car");
    }

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }

    @Override
    public String toString() {
        return "Car [isOn=" + isOn + ", licensePlate=" + licensePlate + "]";
    }

}
