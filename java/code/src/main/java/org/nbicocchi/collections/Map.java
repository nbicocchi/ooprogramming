package org.nbicocchi.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Class showing how to use basic map methods
 *
 * @author Nicola Bicocchi
 */
public class Map {

    public static void main(String[] args) {
        java.util.Map<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("Agata", 2);
        lhm.put("Marzia", 3);
        lhm.put("Nicola", 1);
        lhm.put("Dharma", 1);

        java.util.Map<String, Integer> hm = new HashMap<>(lhm);
        java.util.Map<String, Integer> tm = new TreeMap<>(lhm);

        // original map
        System.out.println(lhm);

        // no particular ordering
        System.out.println(hm);

        // natural ordering
        System.out.println(tm);

        // main functions
        String act;
        act = "Showing content...";
        System.out.println(act);
        for (String s : hm.keySet()) {
            System.out.println(s + " --> " + hm.get(s));
        }

        act = "Removing elements...";
        System.out.println(act);
        System.out.println(hm.remove("Luisa"));

        act = "Showing content...";
        System.out.println(act);
        for (String s : hm.keySet()) {
            System.out.println(s + " --> " + hm.get(s));
        }

        act = "Contains...";
        System.out.println(act);
        System.out.println(hm.containsKey("Marzia"));

        act = "Getting keys...";
        System.out.println(act);
        for (String s : hm.keySet()) {
            System.out.println(s);
        }

        act = "Getting values...";
        System.out.println(act);
        for (int i : hm.values()) {
            System.out.println(i);
        }
    }
}
