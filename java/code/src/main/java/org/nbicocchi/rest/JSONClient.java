package org.nbicocchi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import org.nbicocchi.utils.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JSONClient implements Runnable {
    static Logger logger = LoggerFactory.getLogger(JSONClient.class);
    ObjectMapper om = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public void getAll() {
        String url = "http://localhost:8080/all";
        String json = Unirest.get(url).asString().getBody();

        // JSON to object mapping
        ArrayList<TimeZone> timeZone = null;
        try {
            timeZone = om.readValue(json, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // logging
        logger.info(json);
        logger.info(timeZone != null ? timeZone.toString() : null);
    }

    @Override
    public void run() {
        String[] cities = {"Rome", "Delhi", "NewYork"};
        for (String city : cities) {
            getCity(city);
        }
    }

    public void getCity(String name) {
        String url = String.format("http://localhost:8080/%s", name);
        String json = Unirest.get(url).asString().getBody();

        // JSON to object mapping
        TimeZone timeZone = null;
        try {
            timeZone = om.readValue(json, TimeZone.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // logging
        logger.info(json);
        logger.info(timeZone != null ? timeZone.toString() : null);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new JSONClient(), 0, 5, TimeUnit.SECONDS);
    }

}