package org.nbicocchi.oopinheritance.movableshape;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Movable[] v = new Movable[2];
        v[0] = new MovableRectangle(0, 10, 20, 0);
        v[1] = new MovableCircle(10, 10, 20);

        for (Movable m : v) {
            System.out.println(m);
            m.moveRight();
            m.moveUp();
            System.out.println(m);
        }
    }
}
