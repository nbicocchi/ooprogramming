package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public class ConsumerLinkedQueue<T> extends Consumer<T> {

    public ConsumerLinkedQueue(Queue<T> q) {
        super(q);
    }

    @Override
    public void run() {
        while (running) {
            if (!q.isEmpty()) {
                q.poll();
                System.out.printf("Consumer %s received %d items\n", Thread.currentThread().getName(), count);
                count += 1;
            }
        }
    }
}
