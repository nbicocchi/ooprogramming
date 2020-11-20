package org.nbicocchi.collections.exercises.queues;

public class LIFO extends MyAbstractQueue implements MyQueue {

    @Override
    public Task peek() {
        return tasks.get(tasks.size() - 1);
    }

    @Override
    public Task poll() {
        return tasks.remove(tasks.size() - 1);
    }
}
