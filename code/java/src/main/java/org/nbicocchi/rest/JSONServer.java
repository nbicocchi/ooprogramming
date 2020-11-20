package org.nbicocchi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nbicocchi.utils.TimeZone;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;

public class JSONServer {
    ObjectMapper om = new ObjectMapper();

    TimeZone getTimeZone(String name) {
        Calendar c = Calendar.getInstance(java.util.TimeZone.getTimeZone(name));
        return new TimeZone(name, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
    }

    public void run() {
        // Fill map
        Map<String, String> map = new HashMap<>();
        map.put("Rome", "Europe/Rome");
        map.put("Delhi", "India/Delhi");
        map.put("NewYork", "America/New_York");

        // Start embedded server at this port
        port(8080);

        // Configure resources
        get("/all", (request, response) -> {
            List<TimeZone> l = new ArrayList<>();
            for (String tz : map.values()) {
                l.add(getTimeZone(tz));
            }
            return om.writeValueAsString(l);
        });

        get("/:id", (request, response) -> {
            String id = request.params(":id");
            return om.writeValueAsString(getTimeZone(map.get(id)));
        });

    }

    public static void main(String[] args) {
        new JSONServer().run();
    }
}