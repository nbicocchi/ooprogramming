package org.nbicocchi.threads.managerworkers;

/**
 * Si implementi un’applicazione multi-threaded per la ricerca di numeri primi.
 * Il software deve sfruttare la moderne architetture multi-­‐core suddividendo
 * l’intervallo di numeri interi in cui effettuare la ricerca in blocchi
 * contigui. Ad esempio la ricerca dei primi compresi nell’intervallo [1-­‐1000]
 * potrebbe essere divisa in 10 blocchi contigui di 100 elementi ciascuno. Ogni
 * blocco deve essere processato da un thread separato il quale, una volta
 * terminata la computazione, ritorna i risultati al thread principale. Per
 * ottimizzare la computazione su architetture diverse (e.g., 2/4/8/16 cores) Il
 * numero di thread paralleli deve essere configurabile attraverso un parametro.
 * Ad esempio, i 10 blocchi contigui di cui sopra, potrebbero essere processati
 * solamente da 4 thread paralleli. Non appena un thead termina l’analisi di un
 * blocco, ne riceve da processare uno nuovo fino ad esaurimento. Suggerimento:
 * Per implementare il passaggio dei risultati verso il thread principale,
 * ricordare che ogni thread è, innanzitutto, un oggetto.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        new Manager(0, 100000, 10000, 4).run();
    }
}
