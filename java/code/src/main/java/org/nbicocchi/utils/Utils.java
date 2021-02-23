package org.nbicocchi.utils;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.TimeZone;
import java.util.UUID;

public class Utils {
    public static final String JDBC_Driver_SQLite = "org.sqlite.JDBC";
    public static final String JDBC_URL_SQLite = String.format("jdbc:sqlite:%s",
            Paths.get(Utils.ooprogrammingdir(), "ooprogramming.sqlite").toString());

    public static final String JDBC_Driver_MySQL = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL_MySQL = "jdbc:mysql://localhost:3306/jdbc_schema?user=nicola&password=qwertyuio&serverTimezone=" +
            TimeZone.getDefault().getID();

    public static String ooprogrammingdir() {
        String path = String.format("%s%s%s%s%s", System.getProperty("user.home"), System.getProperty("file.separator"),
                "Desktop", System.getProperty("file.separator"), "ooprgramming");
        new File(path).mkdirs();
        return path;
    }

    public static UUID asUUID(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }

    public static byte[] asBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }
}
