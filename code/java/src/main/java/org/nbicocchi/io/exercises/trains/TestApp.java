package org.nbicocchi.io.exercises.trains;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Si supponga di voler progettare parte del sistema informativo di una azienda
 * di trasporti su rotaia. Per ogni treno occorrerà tenere traccia delle
 * stazioni di fermata, della stazione di partenza e di quella di arrivo, oltre
 * che dei relativi orari. Occorre poi che ad ogni treno sia associato il numero
 * dei posti a sedere disponibili e il numero totale di chilometri percorsi. Nei
 * treni espressi, infine, è previsto anche un servizio ristorante, e anche per
 * questo servizio è necessario tenere traccia del numero di posti disponibili.
 * Un utente di questo sistema informativo potrebbe essere interessato a
 * determinare il numero di fermate effettuate da ciascun treno. Inoltre, chi
 * utilizza tale sistema informativo potrebbe essere interessato a determinare
 * il massimo ricavo realizzabile nellʼerogazione di questo servizio. Tale
 * ricavo dipende dal prezzo che ogni passeggero dovrà pagare per percorrere un
 * chilometro. Nei treni espressi occorrerà tenere conto anche del ricavo che si
 * presume di ottenere in ogni chilometro da ognuno dei posti disponibili nel
 * vagone ristorante (anchʼesso fornito come parametro). Si doti il sistema
 * della possilità di leggere e scrivere lo stato degli oggetti manipolati su:
 * <p>
 * 1. file caratteri 2. file binario (nella forma di strutture dati) 3. file
 * binario (nella forma di oggetti serializzati)
 * <p>
 * In altre parole, si renda funzionante il codice commentato all’interno della
 * classe sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {

    public static void main(String[] args) {
        ArrayList<Train> tList = new ArrayList<>();

        Train t;
        t = new TrainExpress(new Station("Milano", "MX1", "L1"), new Station("Roma", "RM1", "L1"), "11:0:00",
                "14:12:00", 550, 600);

        t.addStop(new Station("Bologna", "BO1", "L1"));
        t.addStop(new Station("Firenze", "FR1", "L1"));
        t.addStop(new Station("Roma Tiburtina", "RM2", "L1"));
        tList.add(t);

        t = new Train(new Station("Milano", "MX1", "L1"), new Station("Napoli", "NP1", "L1"), "17:0:00", "22:22:00",
                450, 500);

        t.addStop(new Station("Bologna", "BO1", "L1"));
        t.addStop(new Station("Roma", "RM1", "L1"));
        tList.add(t);

        // prints trains which are going to be saved
        System.out.println("Trains to be stored:");
        for (Train tr : tList) {
            System.out.println(tr);
        }

        // test writes
        Storage st;
        try {
            st = new TextStorage("StorageText.dat");
            st.store(tList, false);
            System.out.println("TextStorage store OK! " + tList.size() + " trains stored.");

            st = new DataStorage("StorageData.dat");
            st.store(tList, false);
            System.out.println("DataStorage store OK! " + tList.size() + " trains stored.");

            st = new ObjectStorage("StorageObject.dat");
            st.store(tList, false);
            System.out.println("TextStorage store OK! " + tList.size() + " trains stored.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // test reads
        try {
            st = new ObjectStorage("StorageObject.dat");
            tList = (ArrayList<Train>) st.load();
            System.out.println("\nObjectStorage load OK! " + tList.size() + " trains loaded.");
            for (Train tr : tList) {
                System.out.println(tr);
            }

            st = new TextStorage("StorageText.dat");
            tList = (ArrayList<Train>) st.load();
            System.out.println("\nTextStorage load OK! " + tList.size() + " trains loaded.");
            for (Train tr : tList) {
                System.out.println(tr);
            }

            st = new DataStorage("StorageData.dat");
            tList = (ArrayList<Train>) st.load();
            System.out.println("\nDataStorage load OK! " + tList.size() + " trains loaded.");
            for (Train tr : tList) {
                System.out.println(tr);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
