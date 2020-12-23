package org.nbicocchi.threads.producerconsumer;

import java.util.Queue;

public abstract class Producer<T> extends Thread {
    boolean running;
    int count;
    int maxitems;
    T item;
    Queue<T> q;

    public Producer(int maxitems, T item, Queue<T> q) {
        super();
        this.running = true;
        this.count = 0;
        this.maxitems = maxitems;
        this.item = item;
        this.q = q;
    }

}
