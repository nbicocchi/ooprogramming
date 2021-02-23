package org.nbicocchi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Sausage;
import org.nbicocchi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import static spark.Spark.*;

public class JDBCServer {
    static Logger logger = LoggerFactory.getLogger(JDBCServer.class);
    ObjectMapper om = new ObjectMapper();
    Statement statement;

    public static void main(String[] args) {
        new JDBCServer().run();
    }

    public void run() {
        try {
            dbConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Start embedded server at this port
        port(8080);

        // Configure resources

        // POST - Add new
        // For testing:
        // curl -X POST -d length=36.6 -d diameter=29.5 -d weight=4.5 -d quality=Low http://localhost:8080/sausage/add
        post("/sausage/add", (request, response) -> {
            double length = Double.parseDouble(request.queryParams("length"));
            double diameter = Double.parseDouble(request.queryParams("diameter"));
            double weight = Double.parseDouble(request.queryParams("weight"));
            String quality = request.queryParams("quality");
            UUID uuid = UUID.randomUUID();

            Sausage m = new Sausage(uuid, length, diameter, weight, quality);
            String query = String.format(
                    "INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('%s', %f, %f, %f, '%s')", uuid,
                    length, diameter, weight, quality);
            statement.executeUpdate(query);

            response.status(201);
            return om.writeValueAsString(m);
        });

        // PUT - Update
        // For testing: curl -X PUT -d length=36.6 -d diameter=29.5 -d weight=4.5 -d
        // quality=High
        // http://localhost:8080/sausage/214bb0db-aa52-48be-b052-cd30f730ae79
        put("/sausage/:id", (request, response) -> {
            UUID uuid = UUID.fromString(request.params(":id"));
            double length = Double.parseDouble(request.queryParams("length"));
            double diameter = Double.parseDouble(request.queryParams("diameter"));
            double weight = Double.parseDouble(request.queryParams("weight"));
            String quality = request.queryParams("quality");
            String query;

            query = String.format("SELECT * FROM sausage WHERE ID = '%s'", uuid);
            ResultSet rs = statement.executeQuery(query);
            if (!rs.next()) {
                response.status(404);
                return om.writeValueAsString("{status: failed}");
            }

            Sausage m = new Sausage(uuid, length, diameter, weight, quality);
            query = String.format("UPDATE sausage SET length=%f, diameter=%f, weight=%f, quality='%s' WHERE ID = '%s'",
                    length, diameter, weight, quality, uuid);
            statement.executeUpdate(query);
            return om.writeValueAsString(m);
        });

        // DELETE - delete
        // For testing:
        // curl -X DELETE http://localhost:8080/sausage/214bb0db-aa52-48be-b052-cd30f730ae79
        delete("/sausage/:id", (request, response) -> {
            String id = request.params(":id");
            String query;

            query = String.format("SELECT * FROM sausage WHERE ID = '%s'", id);
            ResultSet rs = statement.executeQuery(query);
            if (!rs.next()) {
                response.status(404);
                return om.writeValueAsString("{status: failed}");
            }

            query = String.format("DELETE FROM sausage WHERE ID = '%s'", id);
            statement.executeUpdate(query);
            return om.writeValueAsString("{status: ok}");
        });

        // GET - get all
        // For testing: curl -X GET http://localhost:8080/sausage
        get("/sausage", (request, response) -> {
            String query;

            query = "SELECT * FROM sausage";
            ResultSet rs = statement.executeQuery(query);

            ArrayList<Sausage> l = new ArrayList<>();
            while (rs.next()) {
                l.add(new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                        rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));

            }
            System.out.println(l);
            return om.writeValueAsString(l);
        });

        // GET - get by length
        // For testing:
        // curl -X GET "http://localhost:8080/sausage/bylength?min=28&max=32"
        get("/sausage/bylength", (request, response) -> {
            String min = request.queryParams("min");
            String max = request.queryParams("max");

            String query = String.format("SELECT * FROM sausage WHERE length BETWEEN %s AND %s ORDER BY length", min,
                    max);
            ResultSet rs = statement.executeQuery(query);

            ArrayList<Sausage> l = new ArrayList<>();
            while (rs.next()) {
                l.add(new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                        rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));
            }
            return om.writeValueAsString(l);
        });

        // GET - get by quality
        // For testing:
        // curl -X GET "http://localhost:8080/sausage/byquality?quality=High"
        get("/sausage/byquality", (request, response) -> {
            String quality = request.queryParams("quality");
            String query = String.format("SELECT * FROM sausage WHERE quality='%s'", quality);
            ResultSet rs = statement.executeQuery(query);

            ArrayList<Sausage> l = new ArrayList<>();
            while (rs.next()) {
                l.add(new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                        rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));

            }
            return om.writeValueAsString(l);
        });

        // GET - get by id
        // For testing:
        // curl -X GET "http://localhost:8080/sausage/214bb0db-aa52-48be-b052-cd30f730ae79"
        get("/sausage/:id", (request, response) -> {
            String id = request.params(":id");
            String query;

            query = String.format("SELECT * FROM sausage WHERE ID = '%s'", id);
            ResultSet rs = statement.executeQuery(query);
            if (!rs.next()) {
                response.status(404);
                return om.writeValueAsString("{status: failed}");
            }

            Sausage m = new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                    rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality"));
            return om.writeValueAsString(m);
        });
    }

    public void dbConnection() throws SQLException {
        DBManager.setConnection(
                Utils.JDBC_Driver_SQLite,
                Utils.JDBC_URL_SQLite);
        statement = DBManager.getConnection().createStatement();

        try {
            statement.executeQuery("SELECT * FROM sausage LIMIT 1");
        } catch (SQLException e) {
            try {
                statement.executeUpdate("DROP TABLE IF EXISTS sausage");
                statement.executeUpdate("DROP TABLE IF EXISTS log");
                statement.executeUpdate("CREATE TABLE sausage (" + "id VARCHAR(50) PRIMARY KEY, " + "length REAL, "
                        + "diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");
                statement.executeUpdate(
                        "CREATE TABLE log (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "query VARCHAR(1024))");

                /* Examples for developing */
                statement.executeUpdate(
                        "INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
                statement.executeUpdate(
                        "INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
                statement.executeUpdate(
                        "INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
            } catch (SQLException e1) {
                throw new RuntimeException();
            }
        }
    }
}