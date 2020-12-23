package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public class ProducerSynchronizedWaitNotify<T> extends Producer<T> {

    public ProducerSynchronizedWaitNotify(int maxitems, T item, Queue<T> q) {
        super(maxitems, item, q);
    }

    @Override
    public void run() {
        while (running) {
            synchronized (q) {
                if (q.size() < maxitems) {
                    q.add(item);
                    System.out.printf("Producer %s pushed %d items\n", Thread.currentThread().getName(), count);
                    count += 1;
                    q.notifyAll();
                } else {
                    try {
                        q.wait();
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        }
    }
}
