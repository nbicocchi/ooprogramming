package org.nbicocchi.collections.exercises.library;

/**
 * Una biblioteca ha la necessità di tenere traccia dei prestiti dei libri e
 * dei DVD in catalogo. Ad ogni libro o DVD sarà quindi associata una sequenza
 * di prestiti, ad ognuno dei quali corrispondono la data di inizio prestito, la
 * data di riconsegna, il nome e cognome dellʼutente. Inoltre, per i DVD
 * occorrerà tenere traccia della durata, mentre per i libri occorrerà tenere
 * traccia del numero di pagine. Ad entrambi i tipi di supporti, infine, bisogna
 * associare il titolo e lʼanno di pubblicazione. Il bibliotecario potrebbe
 * essere interessato a calcolare il periodo più lungo (in giorni) in cui un
 * libro o un DVD è rimasto a prestito ad una persona. Occorre infine
 * permettere al bibliotecario di controllare se nella lista di prestiti
 * relativi ad un libro ad un DVD esistano inconsistenze, ovvero se un prestito
 * nella lista sia iniziato prima che un altro prestito fosse concluso.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        new Library();
    }

}
