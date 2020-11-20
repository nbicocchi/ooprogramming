package org.nbicocchi.threads.producerconsumergui;

import javax.swing.*;

/**
 * Si sviluppi un’applicazione grafica che gestisce la velocità di esecuzione di
 * due thread paralleli (produttore-­‐consumatore) che modificano una struttura
 * dati condivisa (i.e., una lista di interi). I due componenti JSlider vengono
 * utilizzati per modificare le rispettive velocità di produttore e consumatore,
 * mentre il component JProgressBar mostra lo stato di riempimento della
 * struttura dati condivisa (che deve essere limitata ad un valore prestabilito)
 * Quando la struttura condivisa è piena il produttore deve arrestarsi, quando
 * la struttura condivisa è vuota il consumatore deve arrestarsi.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProducerConsumerGUI::new);
    }

}
