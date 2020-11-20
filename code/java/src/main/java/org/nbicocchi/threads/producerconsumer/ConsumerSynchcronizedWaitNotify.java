package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public class ConsumerSynchcronizedWaitNotify<T> extends Consumer<T> {

    public ConsumerSynchcronizedWaitNotify(Queue<T> q) {
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
