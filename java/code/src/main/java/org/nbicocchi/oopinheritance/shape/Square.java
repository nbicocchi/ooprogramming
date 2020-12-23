package org.nbicocchi.oopinheritance.shape;

public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setHeight(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
