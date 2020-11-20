package org.nbicocchi.io.exercises.trains;

import java.io.IOException;
import java.util.List;

public abstract class Storage {
    protected String filename;

    public Storage(String filename) {
        this.filename = filename;
    }

    public abstract void store(List<Train> tList, boolean append) throws IOException;

    public abstract List<Train> load() throws IOException, ClassNotFoundException;

}
