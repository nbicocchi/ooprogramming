package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public abstract class Consumer<T> extends Thread {
    public boolean running;
    int count;
    Queue<T> q;

    public Consumer(Queue<T> q) {
        super();
        this.running = true;
        this.count = 0;
        this.q = q;
    }
}
