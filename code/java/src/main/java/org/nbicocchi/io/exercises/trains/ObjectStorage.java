package org.nbicocchi.io.exercises.trains;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStorage extends Storage {

    public ObjectStorage(String filename) {
        super(filename);
    }

    @Override
    public void store(List<Train> tList, boolean append) throws IOException {
        // http://java.sun.com/javase/technologies/core/basic/serializationFAQ.jsp#appendSerialStream
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.filename, false));
        for (Train t : tList) {
            out.writeObject(t);
        }
        out.close();
    }

    @Override
    public List<Train> load() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename));
        List<Train> tList = new ArrayList<>();

        try {
            Object obj;
            while ((obj = in.readObject()) != null) {
                tList.add((Train) obj);
            }
        } catch (EOFException ignored) {
        } finally {
            in.close();
        }

        return tList;
    }
}
