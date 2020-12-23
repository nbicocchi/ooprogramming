package org.nbicocchi.threads;

class SyncThread implements Runnable {
    private final Object obj1;
    private final Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            System.out.println(name + " acquiring lock on " + obj1);
            synchronized (obj1) {
                System.out.println(name + " acquired lock on " + obj1);
                System.out.println(name + " acquiring lock on " + obj2);
                synchronized (obj2) {
                    System.out.println(name + " acquired lock on " + obj2);
                    work();
                }
                System.out.println(name + " released lock on " + obj2);
            }
            System.out.println(name + " released lock on " + obj1);
        }
    }

    private void work() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();

    }

}
