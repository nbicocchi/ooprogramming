package org.nbicocchi.collections.implementations;

/**
 * Implementation of a simplified ArrayList class
 *
 * @author Nicola Bicocchi
 */
public class MyArrayList implements MyList {
    private static final int DEFAULT_CAPACITY = 8;
    private int size;
    private Object[] elements;

    public MyArrayList() {
        // allocate default initial capacity
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Object o : elements) {
            if (o != null) {
                output.append("[").append(o.toString()).append("]");
            }
        }
        return output.toString();
    }

    @Override
    public void add(Object data) {
        // we re-allocate before complete fullness
        if (size >= elements.length - 1) {
            // buffer re-allocation
            Object[] tmp = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                tmp[i] = elements[i];
            }
            elements = tmp;
        }
        elements[size] = data;
        size++;
    }

    @Override
    public void add(Object data, int index) {
        add(data);
        /* move array elements into memory */
        for (int i = elements.length - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = data;
        elements[size] = null;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size())
            return null;
        return elements[index];
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size())
            return false;
        /* move array elements into memory */
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

}
