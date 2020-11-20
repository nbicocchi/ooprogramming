package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public class ProducerLinkedQueue<T> extends Producer<T> {

    public ProducerLinkedQueue(int maxitems, T item, Queue<T> q) {
        super(maxitems, item, q);
    }

    @Override
    public void run() {
        while (running) {
            if (q.size() < maxitems) {
                q.add(item);
                System.out.printf("Producer %s pushed %d items\n", Thread.currentThread().getName(), count);
                count += 1;
            }
        }
    }
}
