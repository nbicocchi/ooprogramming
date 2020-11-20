package org.nbicocchi.generics.exercises.genericqueues;

public interface MyQueue<T> {
    void add(T t);

    T peek();

    T poll();
}
