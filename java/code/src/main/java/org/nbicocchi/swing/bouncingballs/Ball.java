package org.nbicocchi.swing.bouncingballs;

import java.awt.*;

public class Ball {
    protected double r;
    protected Vector2D position, velocity;
    protected Color color;

    public Ball(double x, double y, double r, double vx, double vy, Color color) {
        this.r = r;
        this.position = new Vector2D(x, y);
        this.velocity = new Vector2D(vx, vy);
        this.color = color;
    }

    public boolean overlapsX(int x3, int x4) {
        int x1 = (int) (position.x - r);
        int x2 = (int) (position.x + r);

        return (x1 >= x3 && x1 <= x4) ||
                (x2 >= x3 && x2 <= x4) ||
                (x3 >= x1 && x3 <= x2) ||
                (x4 >= x1 && x4 <= x2);
    }

    public boolean overlapsY(int y3, int y4) {
        int y1 = (int) (position.y - r);
        int y2 = (int) (position.y + r);

        return (y1 >= y3 && y1 <= y4) ||
                (y2 >= y3 && y2 <= y4) ||
                (y3 >= y1 && y3 <= y2) ||
                (y4 >= y1 && y4 <= y2);
    }

    public void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    public boolean collideWall(int w, int h) {
        if (position.x - r < 0 || position.x + r > w) {
            velocity.x = -velocity.x;
            return true;
        }

        if (position.y - r < 0 || position.y + r > h) {
            velocity.y = -velocity.y;
            return true;
        }
        return false;
    }

    public boolean collideBall(Ball ob) {
        Vector2D d = position.sub(ob.position);

        return d.length() <= r + ob.r;
    }

    public void revolve(Ball ob) {
        // get the mtd
        Vector2D delta = position.sub(ob.position);
        double d = delta.length();
        // minimum translation distance to push balls apart after intersecting
        Vector2D mtd = delta.multiply(((r + ob.r) - d) / d);

        // resolve intersection --
        // inverse mass quantities
        double im1 = 1 / r;
        double im2 = 1 / ob.r;

        // push-pull them apart based off their mass
        position = position.add(mtd.multiply(im1 / (im1 + im2)));
        ob.position = ob.position.sub(mtd.multiply(im2 / (im1 + im2)));

        //velocity = velocity.dot(delta);
        double projVel = velocity.dot(delta) / delta.length();
        Vector2D a = new Vector2D(delta);
        a.normalize();
        a.multiply(projVel);
        velocity = velocity.add(a).normalize();
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (position.x - r), (int) (position.y - r), (int) (r * 2), (int) (r * 2));
    }
}
