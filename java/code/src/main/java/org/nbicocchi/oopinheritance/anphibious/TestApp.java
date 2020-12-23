package org.nbicocchi.oopinheritance.anphibious;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Anphibious a = new Anphibious();
        a.run();
        a.sail();
    }
}