package org.nbicocchi.generics;

/**
 * A generic product
 *
 * @author Nicola Bicocchi
 */
public class Product {
    public String description;

    public Product() {
        super();
        description = "A product";
    }

    @Override
    public String toString() {
        return description;
    }
}
