package org.nbicocchi.threads;

class Counter implements Runnable {
    int n;

    public Counter(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++)
            System.out.println(Thread.currentThread().getName() + " " + i);
    }
}

public class MultipleThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Counter(500), "C1");
        Thread t2 = new Thread(new Counter(500), "C2");
        Thread t3 = new Thread(new Counter(500), "C3");
        t1.start();
        t2.start();
        t3.start();
    }
}
