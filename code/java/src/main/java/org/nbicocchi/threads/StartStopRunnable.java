package org.nbicocchi.threads;

class MyRunnable implements Runnable {
    public boolean running = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        while (running) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }
}

public class StartStopRunnable {
    public static void main(String[] args) {
        MyRunnable r01 = new MyRunnable();
        MyRunnable r02 = new MyRunnable();

        Thread a = new Thread(r01, "Homer");
        Thread b = new Thread(r02, "Marge");

        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);

        a.start();
        b.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Graceful shutdown!
        r01.running = false;
        r02.running = false;

        // Ungraceful shutdown!
        // a.interrupt();
        // b.interrupt();

    }
}
