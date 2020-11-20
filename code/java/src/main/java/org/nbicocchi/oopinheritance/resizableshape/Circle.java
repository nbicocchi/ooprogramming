package org.nbicocchi.oopinheritance.resizableshape;

public class Circle implements GeometricObject, Resizable {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(int percent) {
        radius *= percent;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter() + "]";
    }
}
