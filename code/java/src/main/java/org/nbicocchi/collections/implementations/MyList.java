package org.nbicocchi.collections.implementations;

/**
 * Interface representing basic List operations
 *
 * @author Nicola Bicocchi
 */
public interface MyList {
    void add(Object data);

    void add(Object data, int index);

    Object get(int index);

    boolean remove(int index);

    int size();
}
