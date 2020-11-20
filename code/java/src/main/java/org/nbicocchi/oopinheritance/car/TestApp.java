package org.nbicocchi.oopinheritance.car;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        /* Implicit form of upcasting */
        Car[] garage = new Car[3];
        garage[0] = new Car("AA456YY");
        garage[1] = new Car("YY555WW");
        garage[2] = new SDCar("TT543EE");

        for (Car c : garage) {
            System.out.println(c);
        }
    }
}
