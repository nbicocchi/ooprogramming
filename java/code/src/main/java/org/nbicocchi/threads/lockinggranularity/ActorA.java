package org.nbicocchi.threads.lockinggranularity;

public class ActorA extends Thread {
    SharedResource sr;
    boolean running = true;

    public ActorA(SharedResource sr) {
        super();
        this.sr = sr;
    }

    @Override
    public void run() {
        while (running) {
            sr.A();
        }
    }
}
