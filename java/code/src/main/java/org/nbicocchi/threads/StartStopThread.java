package org.nbicocchi.threads;

class MyThread extends Thread {
    public boolean running = true;

    public MyThread(String name) {
        super(name);
    }

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

public class StartStopThread {

    public static void main(String[] args) {
        MyThread a = new MyThread("Homer");
        MyThread b = new MyThread("Marge");

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
        a.running = false;
        b.running = false;

        // Ungraceful shutdown!
        // a.interrupt();
        // b.interrupt();

    }
}
