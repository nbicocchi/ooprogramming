package org.nbicocchi.threads.lockinggranularity;

public class ActorC extends Thread {
    SharedResource sr;
    boolean running = true;

    public ActorC(SharedResource sr) {
        super();
        this.sr = sr;
    }

    @Override
    public void run() {
        while (running) {
            sr.C();
        }
    }
}
