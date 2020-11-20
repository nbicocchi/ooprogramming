package org.nbicocchi.collections.exercises.queues;

public interface MyQueue {
    void add(Task t);

    Task peek();

    Task poll();
}
