package org.nbicocchi.generics;

import java.util.*;

/**
 * A generic shop capable of both buying and selling products. Wrong
 * implementation in case 4!
 *
 * @param <T>
 * @author Nicola Bicocchi
 */
public class ShopWrong<T> implements Iterable<T> {
    private final LinkedList<T> l;

    public ShopWrong() {
        l = new LinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return l.iterator();
    }

    public static void main(String[] args) {
        ShopWrong<Fruit> fs = new ShopWrong<>();
        ShopWrong<Product> ps = new ShopWrong<>();

        List<Fruit> lf;

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
        ps.buy(new Fruit());
        System.out.println(ps.sell());

        // CASE4: Sub-typing (Collections) NOT working!
        System.out.println("Sub-typing (Collections) NOT working!");
        lf = new ArrayList<>(Arrays.asList(new Fruit(), new Fruit(), new Fruit()));

        // compile error if uncommented
        // ps.buy(lf);

        // compile error if uncommented
        // fs.sell(new ArrayList<Product>(), 3);
    }

    void buy(T item) {
        l.addFirst(item);
    }

    T sell() {
        return l.removeLast();
    }

    void buy(List<T> items) {
        l.addAll(items);
    }

    void sell(List<T> items, int nItems) {
        for (int i = 0; i < nItems; i++) {
            items.add(l.removeLast());
        }
    }
}
