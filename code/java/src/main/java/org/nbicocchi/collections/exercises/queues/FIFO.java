package org.nbicocchi.collections.exercises.queues;

public class FIFO extends MyAbstractQueue implements MyQueue {

    @Override
    public Task peek() {
        return tasks.get(0);
    }

    @Override
    public Task poll() {
        return tasks.remove(0);
    }
}
