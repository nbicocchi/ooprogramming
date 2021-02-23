package org.nbicocchi.generics;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * A generic shop capable of both buying and selling products
 *
 * @param <T>
 * @author Nicola Bicocchi
 */
public class Shop<T> implements Iterable<T> {
    private final LinkedList<T> l;

    public Shop() {
        l = new LinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return l.iterator();
    }

    public static void main(String[] args) {
        Shop<Fruit> fs = new Shop<>();
        Shop<Product> ps = new Shop<>();

        List<Fruit> lf;
        List<Product> lp;

        // CASE1: Single type (Single Object)
        System.out.println("CASE1: Single type (Single Object)");
        fs.buy(new Fruit());
        System.out.println(fs.sell());

        // CASE2: Single type (Collections)
        System.out.println("CASE2: Single type (Collections)");
        lf = new ArrayList<>(Arrays.asList(new Fruit(), new Fruit(), new Fruit()));
        fs.buy(lf);

        lf.clear();
        fs.sell(lf, 2);
        System.out.println(lf);

        // CASE3: Sub-typing (Single Object)
        System.out.println("CASE3: Sub-typing (Single Object)");
        ps.buy(new Vegetable());
        System.out.println(ps.sell());

        // CASE4: Sub-typing (Collections)
        System.out.println("Sub-typing (Collections) NOT working!");
        lf = new ArrayList<>(Arrays.asList(new Fruit(), new Fruit(), new Fruit()));

        ps.buy(lf);
        fs.buy(lf);

        lp = new ArrayList<>();
        fs.sell(lp, 3);
        System.out.println(lp);
    }

    void buy(T item) {
        l.addFirst(item);
    }

    T sell() {
        return l.removeLast();
    }

    void buy(List<? extends T> items) {
        l.addAll(items);
    }

    void sell(List<? super T> items, int nItems) {
        for (int i = 0; i < nItems; i++) {
            items.add(l.removeLast());
        }
    }
}
