package org.nbicocchi.oop;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Per un programma di geometria piana, realizzare la classe Shape che dispone
 * dei metodi getWidth(), getHeight(), getPosX() e getPosY(), che restituiscono
 * rispettivamente la larghezza, l’altezza, la posizione sulle ascisse e sulle
 * ordinate del più piccolo rettangolo che contiene interamente la figura in
 * questione (le coordinate restituite da getPosX() e getPosY() si riferiscono
 * al vertice in basso a sinistra del rettangolo).
 * <p>
 * Gli oggetti Shape sono dotati di ordinamento naturale, sulla base dell’area
 * del rettangolo che contiene la figura.
 * <p>
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
 */
public class Shape implements Comparable<Shape> {
    double width;
    double height;
    double posX;
    double posY;

    public Shape(double width, double height, double posX, double posY) {
        super();
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int compareTo(Shape o) {
        return Double.compare(width * height, o.width * o.height);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "width=" + width +
                ", height=" + height +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Shape> l = new ArrayList<>();
        l.add(new Shape(100, 100, 0, 0));
        l.add(new Shape(200, 120, 10, 10));
        l.add(new Shape(50, 70, -10, -10));

        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);

        Shape s = l.get(0);
        s.setPosX(5);
        s.setPosY(5);
        System.out.println(s.getPosX() + " " + s.getPosY());
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
