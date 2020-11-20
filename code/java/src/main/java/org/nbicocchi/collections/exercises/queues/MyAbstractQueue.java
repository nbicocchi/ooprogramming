package org.nbicocchi.collections.exercises.queues;

import java.util.LinkedList;
import java.util.List;

public abstract class MyAbstractQueue implements MyQueue {
    List<Task> tasks;

    public MyAbstractQueue() {
        tasks = new LinkedList<>();
    }

    public void add(Task t) {
        tasks.add(t);
    }
}
