package org.nbicocchi.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class InterceptionModels {
    public static void main(String[] args) {
        new InterceptionModels().f(5);
    }

    public void f(int i) {
        g(i);
    }

    public void g(int i) {
        // RuntimeException (Unchecked)
        // new ArrayList().get(i);

        // IOException (Checked)
        try {
            FileReader r = new FileReader("/tmp/nonexistentfile_" + i);
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}