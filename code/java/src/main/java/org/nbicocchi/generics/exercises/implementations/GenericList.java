package org.nbicocchi.generics.exercises.implementations;

/**
 * Interface representing basic list operations
 *
 * @author Nicola Bicocchi
 */
public interface GenericList<T> {
    void add(T data);

    void add(T data, int index);

    T get(int index);

    boolean remove(int index);

    int size();
}
