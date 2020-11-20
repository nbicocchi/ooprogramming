package org.nbicocchi.threads;

public class CheckPreemption implements Runnable {
    boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName());

            // yield() release CPU control
            Thread.yield();
        }
    }

    public static void main(String[] argv) {
        CheckPreemption c = new CheckPreemption();
        new Thread(c, "... to be").start();
        new Thread(c, "not to be").start();
    }
}
