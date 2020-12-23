package org.nbicocchi.oopinheritance.motorbike;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Motorbike m1 = new Motorbike("Yamaha", "FZ1");
        MotorbikeSold m2 = new MotorbikeSold("Guzzi", "Stelvio");

        System.out.println(m1);
        System.out.println(m2);

        m2.setSpeed(200);

        System.out.println(m1);
        System.out.println(m2);
    }
}
