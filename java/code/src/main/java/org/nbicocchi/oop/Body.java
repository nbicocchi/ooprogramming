package org.nbicocchi.oop;

/**
 * Nel contesto di un programma di simulazione per la cinematica, si implementi
 * una classe Body che rappresenta un corpo puntiforme dotato di posizione nel
 * piano cartesiano e di velocità.
 *
 * Il costruttore della classe prende come argomento le coordinate alle quali si
 * trova inizialmente il corpo; il corpo si suppone inizialmente in quiete. Il
 * metodo setSpeed(v_x, v_y) prende il valore della velocità lungo i due assi
 * di riferimento. Si supponga che la posizione sia espressa in metri e la
 * velocità in metri al secondo. Il metodo progress(t) simula il passaggio di
 * un dato numero di secondi, andando ad aggiornare la posizione del corpo. Il
 * metodo toString va ridefinito in modo da mostrare la posizione corrente del
 * corpo.
 *
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
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
     * @param x the x coordinate
     * @param y the y coordinate
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
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @param x set the x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @param y set the y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the x component of velocity
     */
    public double getvX() {
        return vX;
    }

    /**
     * @param vX set the x component of velocity
     */
    public void setvX(double vX) {
        this.vX = vX;
    }

    /**
     * @return the y component of velocity
     */
    public double getvY() {
        return vY;
    }

    /**
     * @param vY the y component of velocity
     */
    public void setvY(double vY) {
        this.vY = vY;
    }

    /**
     * Set the x and y components of velocity
     * @param vX the x component of velocity
     * @param vY the y component of velocity
     */
    public void setSpeed(double vX, double vY) {
        this.vX = vX;
        this.vY = vY;
    }

    /**
     * Move the body in x and y assuming vX and vY acticing for the specified time
     * @param t the duration of movement (in seconds)
     */
    public void progress(double t) {
        x += vX * t;
        y += vY * t;
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

}
