package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

class ConsumerSynchcronized<T> extends Consumer<T> {

    public ConsumerSynchcronized(Queue<T> q) {
        super(q);
    }

    @Override
    public void run() {
        while (running) {
            synchronized (q) {
                if (!q.isEmpty()) {
                    q.poll();
                    System.out.printf("Consumer %s received %d items\n", Thread.currentThread().getName(), count);
                    count += 1;
                }
            }
        }
    }
}
