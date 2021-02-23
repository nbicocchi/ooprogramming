package org.nbicocchi.oop;

/**
 * Implement a Body class representing a two-dimensional point (x, y) capable of
 * moving with a certain speed (vx, vy).
 * <p>
 * The class have to implement three constructors: Body() - Setting x = y = vy =
 * vy = 0 Body(x, y) Setting x, y as parameters and vx = vy = 0 Body(x, y, vx,
 * vy) Setting x, y, vx, vy
 * <p>
 * The class have also to implement the following methods: getters and setters
 * for x, y, vx, vy progress(t) updating coordinates x, y by considering a
 * steady movement at velocity vx, vy toString() printing x, y, vx, vy
 * <p>
 * Also, a demonstrative main() function have to be implemented.
 *
 * @author Nicola Bicocchi
 * <p>
 * https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
 */
public class Body {
    /**
     * x coordinate of body's location
     */
    double x;

    /**
     * y coordinate of body's location
     */
    double y;

    /**
     * x component of body's velocity
     */
    double vX;

    /**
     * y component of body's velocity
     */
    double vY;

    /**
     * Constructs a body at the origin of coordinates with velocity zero
     */
    public Body() {
        this.x = 0;
        this.y = 0;
        this.vX = 0;
        this.vY = 0;
    }

    /**
     * Constructs a body at the specified coordinates with velocity zero
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Body(double x, double y) {
        this.x = x;
        this.y = y;
        this.vX = 0;
        this.vY = 0;
    }

    /**
     * Constructs a body at the specified coordinates and velocity
     *
     * @param x  the x coordinate
     * @param y  the y coordinate
     * @param vX the x speed
     * @param vY the y speed
     */
    public Body(double x, double y, double vX, double vY) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
    }

    /**
     * Get the x coordinate of body
     *
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Set the x coordinate of body
     *
     * @param x set the x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Get the y coordinate of body
     *
     * @return return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Set the y coordinate of body
     *
     * @param y set the y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the x component of velocity
     *
     * @return the x component of velocity
     */
    public double getVX() {
        return vX;
    }

    /**
     * Set the x component of velocity
     *
     * @param vX set the x component of velocity
     */
    public void setVX(double vX) {
        this.vX = vX;
    }

    /**
     * Get the y component of velocity
     *
     * @return the y component of velocity
     */
    public double getVY() {
        return vY;
    }

    /**
     * Set the y component of velocity
     *
     * @param vY the y component of velocity
     */
    public void setVY(double vY) {
        this.vY = vY;
    }

    @Override
    public String toString() {
        return "Body{" +
                "x=" + x +
                ", y=" + y +
                ", v_x=" + vX +
                ", v_y=" + vY +
                '}';
    }

    public static void main(String[] args) {
        Body b = new Body(0, 0);
        b.setSpeed(1, 1);
        b.progress(1);
        System.out.println(b);
        b.setSpeed(-1, -1);
        b.progress(2);
        System.out.println(b);
    }

    /**
     * Set the x and y components of velocity
     *
     * @param vX the x component of velocity
     * @param vY the y component of velocity
     */
    public void setSpeed(double vX, double vY) {
        this.vX = vX;
        this.vY = vY;
    }

    /**
     * Move the body in x and y assuming vX and vY acting for the specified
     * time
     *
     * @param t the duration of movement (in seconds)
     */
    public void progress(double t) {
        x += vX * t;
        y += vY * t;
    }

}
