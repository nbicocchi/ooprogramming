package org.nbicocchi.oop;

/**
 * Nel contesto di un programma di simulazione per la cinematica, si implementi
 * una classe Body che rappresenta un corpo puntiforme dotato di posizione nel
 * piano cartesiano e di velocità.
 * <p>
 * Il costruttore della classe prende come argomento le coordinate alle quali si
 * trova inizialmente il corpo; il corpo si suppone inizialmente in quiete. Il
 * metodo setSpeed(v_x, v_y) prende il valore della velocità lungo i due assi
 * di riferimento. Si supponga che la posizione sia espressa in metri e la
 * velocità in metri al secondo. Il metodo progress(t) simula il passaggio di
 * un dato numero di secondi, andando ad aggiornare la posizione del corpo. Il
 * metodo toString va ridefinito in modo da mostrare la posizione corrente del
 * corpo.
 * <p>
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
 */
public class Body {
    double x, y, v_x, v_y;

    public Body() {
        this.x = 0;
        this.y = 0;
        this.v_x = 0;
        this.v_y = 0;
    }

    public Body(double x, double y) {
        this.x = x;
        this.y = y;
        this.v_x = 0;
        this.v_y = 0;
    }

    public Body(double x, double y, double v_x, double v_y) {
        this.x = x;
        this.y = y;
        this.v_x = v_x;
        this.v_y = v_y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getV_x() {
        return v_x;
    }

    public void setV_x(double v_x) {
        this.v_x = v_x;
    }

    public double getV_y() {
        return v_y;
    }

    public void setV_y(double v_y) {
        this.v_y = v_y;
    }

    public void setSpeed(double v_x, double v_y) {
        this.v_x = v_x;
        this.v_y = v_y;
    }

    public void progress(double t) {
        x += v_x * t;
        y += v_y * t;
    }

    @Override
    public String toString() {
        return "Body{" +
                "x=" + x +
                ", y=" + y +
                ", v_x=" + v_x +
                ", v_y=" + v_y +
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
