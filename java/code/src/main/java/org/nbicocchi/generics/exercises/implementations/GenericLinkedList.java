package org.nbicocchi.generics.exercises.implementations;

/**
 * Simplified implementation of a generic LinkedList
 *
 * @author Nicola Bicocchi
 */
public class GenericLinkedList<T> extends GenericAbstractList<T> {

    private Node<T> head = null;
    private int size = 0;

    public GenericLinkedList() {

    }

    @Override
    public void add(T data) {
        Node<T> temp = new Node<>(data);

        if (head != null) {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        } else {
            head = temp;
        }
        size++;
    }

    @Override
    public void add(T data, int index) {
        int i = 0;
        Node<T> temp = new Node<>(data);

        if (head != null) {
            Node<T> current = head;
            while (current.getNext() != null && i++ < index) {
                current = current.getNext();
            }
            current.setNext(temp);
            temp.setNext(current.getNext());
        } else {
            head = temp;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0)
            return null;

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return null;
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size())
            return false;

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return false;
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}