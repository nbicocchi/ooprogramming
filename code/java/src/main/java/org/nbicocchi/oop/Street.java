package org.nbicocchi.oop;

import java.util.Arrays;

/**
 * Implementare una classe Street, che rappresenta una strada a senso unico. Il
 * costruttore accetta la lunghezza della strada in chilometri. Il metodo
 * insertCar() accetta un intero (km) come argomento ed aggiunge un’automobile
 * al chilometro km. L’automobile inserita percorrerà la strada alla velocità
 * di un chilometro al minuto, (60 km/h) fino alla fine della stessa. Il metodo
 * getCarsByPosition() riceve come parametro un intero (km) e restituisce il
 * numero di automobili presenti al chilometro km. Il metodo progress() simula
 * il passaggio di 1 minuto di tempo (cioè fa avanzare tutte le automobili di
 * un chilometro).
 * <p>
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
 */
public class Street {
    int[] cars;

    public Street(int km) {
        cars = new int[km];
    }

    public int[] getCars() {
        return cars;
    }

    public void insertCar(int km) {
        cars[km]++;
    }

    public int getCarsByPosition(int km) {
        return cars[km];
    }

    public void progress() {
        for (int i = cars.length - 1; i > 0; i--) {
            cars[i] = cars[i - 1];
        }
        cars[0] = 0;
    }

    @Override
    public String toString() {
        return "Street [cars=" + Arrays.toString(cars) + "]";
    }

    public static void main(String[] args) {
        Street s = new Street(10);
        s.insertCar(0);
        s.insertCar(0);
        s.insertCar(5);
        s.insertCar(9);

        System.out.println("km 0 = " + s.getCarsByPosition(0));
        System.out.println("km 1 = " + s.getCarsByPosition(1));

        System.out.println(s);
        s.progress();
        System.out.println(s);
    }
}
