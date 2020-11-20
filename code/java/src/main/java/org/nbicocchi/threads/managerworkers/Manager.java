package org.nbicocchi.threads.managerworkers;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    int start, stop, blocksize, nthreads;
    Thread[] threads;
    List<Integer> results;

    public Manager(int start, int stop, int blocksize, int nthreads) {
        this.start = start;
        this.stop = stop;
        this.blocksize = blocksize;
        this.nthreads = nthreads;
        this.results = new ArrayList<>();
    }

    public void run() {
        threads = new Thread[nthreads];
        for (int i = 0; i < nthreads; i++) {
            threads[i] = new Thread(new Worker(this, start + 1, blocksize - 1));
            threads[i].start();
            start += blocksize;
        }
    }

    /* Synchronized callback function called by Workers */
    public synchronized void listen(Thread t, List<Integer> l) {
        System.out.printf("[Manager*] Received %d primes from thread %s\n", l.size(), t.getName());
        results.addAll(l);

        /* Eventually start a new worker, replacing the finished one */
        if (start < stop) {
            for (int i = 0; i < nthreads; i++) {
                if (threads[i] == t) {
                    threads[i] = new Thread(new Worker(this, start + 1, blocksize - 1));
                    threads[i].start();
                    start += blocksize;
                }
            }
        }

        /* check for termination */
        int stillRunning = 0;
        for (int i = 0; i < nthreads; i++) {
            if (threads[i].isAlive()) {
                stillRunning += 1;
            }
        }

        if (stillRunning == 1) {
            System.out.printf("[Manager*] Received %d primes overall\n", results.size());
            System.out.print("[Manager*] Halt!\n");
            System.exit(0);
        }
    }
}
