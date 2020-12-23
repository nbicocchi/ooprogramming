package org.nbicocchi.collections.implementations;

public class TestApp {
    public static void main(String[] args) {

        // MyArrayList
        MyList al = new MyArrayList();

        al.add("alpha");
        al.add("beta");

        System.out.println(al.get(0));
        System.out.println(al.get(1));

        // MyLinkedList
        MyLinkedList ll = new MyLinkedList();

        ll.add("alpha");
        ll.add("beta");
        ll.add("delta");
        ll.add("omega");

        System.out.println(ll.get(0));
        System.out.println(ll.get(1));

        // MyQueue
        System.out.println(((MyQueue) ll).getFirst());
        System.out.println(((MyQueue) ll).getLast());

        // MyHashMap
        MyHashMap m = new MyHashMap();
        m.put(11, 113);
        m.put(21, 112);
        m.put(33, 118);

        System.out.println(m.get(21));
        System.out.println(m);
    }
}
