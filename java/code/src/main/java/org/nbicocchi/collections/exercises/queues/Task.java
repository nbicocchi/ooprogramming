package org.nbicocchi.collections.exercises.queues;

public class Task implements Comparable<Task> {
    String ID;
    int priority;

    public Task(String ID, int priority) {
        this.ID = ID;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task [ID=" + ID + ", priority=" + priority + "]";
    }

    @Override
    public int compareTo(Task o) {
        return (priority - o.priority);
    }

}
