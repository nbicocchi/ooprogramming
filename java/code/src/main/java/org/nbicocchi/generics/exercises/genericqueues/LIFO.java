package org.nbicocchi.generics.exercises.genericqueues;

public class LIFO<T> extends MyAbstractQueue<T> implements MyQueue<T> {

    @Override
    public T peek() {
        return elements.getFirst();
    }

    @Override
    public T poll() {
        return elements.removeFirst();
    }
}
