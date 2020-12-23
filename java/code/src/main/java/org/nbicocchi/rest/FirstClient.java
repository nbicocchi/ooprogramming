package org.nbicocchi.rest;

import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FirstClient implements Runnable {
    static Logger logger = LoggerFactory.getLogger(FirstClient.class);

    @Override
    public void run() {
        String url = "http://localhost:8080/";
        String json = Unirest.get(url).asString().getBody();
        logger.info(json);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new FirstClient(), 0, 5, TimeUnit.SECONDS);
    }
}