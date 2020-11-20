package org.nbicocchi.swing.bouncingballs;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }

    public Vector2D sub(Vector2D v) {
        return new Vector2D(x - v.x, y - v.y);
    }

    public Vector2D multiply(double f) {
        return new Vector2D(x * f, y * f);
    }

    public Vector2D normalize() {
        double l = Math.sqrt((x * x) + (y * y));
        return new Vector2D(x / l, y / l);
    }

    public double dot(Vector2D v) {
        return x * v.x + y * v.y;
    }

    public double length() {
        return Math.sqrt((x * x) + (y * y));
    }

    public double lengthSquared() {
        return (x * x) + (y * y);
    }
}
