package org.nbicocchi.oop;

/**
 * Scrivere una classe "Table" per rappresentare tavole pitagoriche. In
 * particolare, la classe è dotata: (a) di un costruttore senza parametri che
 * configura una tavola 10x10, (b) un costruttore che accetta due parametri
 * interi (a, b) che configura una tavola axb, (c) un metodo toString() che
 * ritorna una stringa che rappresenta la tavola, e (d) un metodo sum() che
 * ritorna un numero intero che rappresenta la somma di tutti i numeri presenti
 * nella tavola.
 *
 * @author Nicola Bicocchi
 */
public class Table {
    int a, b;
    boolean ready = false;
    int sum;
    String table;

    public Table() {
        super();
        this.a = 10;
        this.b = 10;
    }

    public Table(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    private void compute() {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                sb.append(i * j).append("\t");
                sum += i * j;
            }
            sb.append("\n");
        }
        table = sb.toString();
        ready = true;
    }

    public int sum() {
        if (!ready)
            compute();
        return sum;
    }

    @Override
    public String toString() {
        if (!ready)
            compute();
        return table;
    }

    public static void main(String[] args) {
        Table t = new Table(8, 8);
        System.out.println(t);
        System.out.println(t.sum());
    }
}
