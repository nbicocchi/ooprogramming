package org.nbicocchi.threads.managerworkers;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {
    Manager manager;
    int start;
    int range;
    boolean running = true;
    List<Integer> results;

    public Worker(Manager man, int start, int range) {
        this.manager = man;
        this.start = start;
        this.range = range;
        results = new ArrayList<>();
    }

    public boolean isRunning() {
        return running;
    }

    private boolean isPrime(int n) {
        if (n == 1)
            return true;
        int i = 2;
        while (n % i > 0)
            i++;
        return i == n;
    }

    @Override
    public void run() {
        System.out.printf("[%s] Analyzing range: %d - %d\n", Thread.currentThread().getName(), start, start + range);

        for (int i = start; i < (start + range); i++) {
            if (isPrime(i))
                results.add(i);
        }

        /* Callback to PrimeProducer for sending results */
        manager.listen(Thread.currentThread(), results);
        running = false;
    }

}