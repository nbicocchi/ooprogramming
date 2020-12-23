package org.nbicocchi.collections.exercises.queues;

import java.util.Collections;

public class FIFOP extends MyAbstractQueue implements MyQueue {

    @Override
    public void add(Task t) {
        tasks.add(t);
        Collections.sort(tasks);
    }

    @Override
    public Task peek() {
        return tasks.get(tasks.size() - 1);
    }

    @Override
    public Task poll() {
        return tasks.remove(tasks.size() - 1);
    }

}
