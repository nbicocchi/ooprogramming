package org.nbicocchi.generics.exercises.genericqueues;

public class Product implements Comparable<Product> {
    String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + "]";
    }

    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.name);
    }
}
