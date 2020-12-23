package org.nbicocchi.generics.exercises.genericqueues;

import java.util.LinkedList;

public abstract class MyAbstractQueue<T> implements MyQueue<T> {
    LinkedList<T> elements;

    public MyAbstractQueue() {
        elements = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        elements.addFirst(t);
    }
}
