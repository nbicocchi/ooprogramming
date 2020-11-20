package org.nbicocchi.swing.imagecomparator;

import javax.swing.*;

/**
 * Si tratta di costruire un’applicazione che consente di valutare le
 * performance di diversi algoritmi per calcolare il livello di somiglianza di
 * due immagini. In particolare, l’applicazione prevede due pannelli
 * (scrollabili) per mostrare le due immagini da confrontare. Inoltre, ogni
 * qualvolta l’utente avvia il confronto, un dialogo consente di selezionare
 * l’algoritmo preferito ed eventualmente di annullare l’operazione. Infine, una
 * barra di progresso mostra l’avanzamento dell’algoritmo durante la
 * computazione.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageFrame::new);
    }
}
