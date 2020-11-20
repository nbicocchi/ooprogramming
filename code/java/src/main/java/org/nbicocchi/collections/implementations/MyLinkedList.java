package org.nbicocchi.collections.implementations;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
class Node {
    // reference to the next node in the chain,
    // or null if there isn't one.
    Node next;
    // data carried by this node.
    // could be of any type you need.
    Object data;

    // Node constructor
    public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }

    // these methods should be self-explanatory
    public Object getData() {
        return data;
    }

    public void setData(Object dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }
}

/**
 * Implementation of a simplified LinkedList class
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedList implements MyList, MyQueue {
    private Node head;
    private int size;

    // LinkedList constructor
    public MyLinkedList() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = null;
        size = 0;
    }

    @Override
    public void add(Object data) {
        // first element
        if (head == null) {
            head = new Node(data);
            size = 1;
            return;
        }

        // appends the specified element to the end of this list.
        Node temp = new Node(data);
        Node current = head;
        // starting at the head node, crawl to the end of the list
        while (current.getNext() != null) {
            current = current.getNext();
        }
        // the last node's "next" reference set to our new node
        current.setNext(temp);
        size++;// increment the number of elements variable
    }

    @Override
    public void add(Object data, int index) {
        // inserts the specified element at the specified position in this list
        Node temp = new Node(data);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        // set the new node's next-node reference to this node's next-node
        // reference
        temp.setNext(current.getNext());
        // now set this node's next-node reference to the new node
        current.setNext(temp);
        size++;// increment the number of elements variable
    }

    @Override
    public Object get(int index) {
        // returns the element at the specified position in this list.
        // index must be 1 or higher
        if (index < 0)
            return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return null;
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean remove(int index) {
        // removes the element at the specified position in this list.
        // if the index is out of range, exit
        if (index < 0 || index >= size())
            return false;

        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return false;
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--; // decrement the number of elements variable
        return true;
    }

    @Override
    public int size() {
        // returns the number of elements in this list.
        return size;
    }

    @Override
    public String toString() {
        Node current = head.getNext();
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append("[").append(current.getData().toString()).append("]");
            current = current.getNext();
        }
        return output.toString();
    }

    @Override
    public Object getFirst() {
        return get(0);
    }

    @Override
    public Object getLast() {
        return get(size - 1);
    }
}