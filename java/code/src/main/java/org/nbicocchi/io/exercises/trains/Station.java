package org.nbicocchi.io.exercises.trains;

import java.io.Serializable;

public class Station implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String code;
    private final String line;

    public Station(String name, String code, String line) {
        this.name = name;
        this.code = code;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return name + "," + code + "," + line;
    }
}
