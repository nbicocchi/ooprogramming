package org.nbicocchi.oopinheritance.resizableshape;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println(c);
        c.resize(2);
        System.out.println(c);
    }
}
