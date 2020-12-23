package org.nbicocchi.oopinheritance.movableshape;

public class MovablePoint implements Movable {
    int x;
    int y;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y += 1;
    }

    @Override
    public void moveDown() {
        y -= 1;
    }

    @Override
    public void moveLeft() {
        x -= 1;
    }

    @Override
    public void moveRight() {
        x += 1;
    }

    @Override
    public String toString() {
        return "MovablePoint [x=" + x + ", y=" + y + "]";
    }
}
