package org.nbicocchi.io.exercises.trains;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorage extends Storage {

    public DataStorage(String filename) {
        super(filename);
    }

    @Override
    public void store(List<Train> tList, boolean append) throws IOException {
        FileOutputStream out = new FileOutputStream(this.filename, append);

        for (Train t : tList) {
            out.write(t.toByteArray());
        }
        out.close();
    }

    @Override
    public List<Train> load() throws IOException {
        FileInputStream in = new FileInputStream(this.filename);
        ArrayList<Train> tList = new ArrayList<>();

        Train t;
        while ((t = Train.readBinary(in)) != null) {
            tList.add(t);
        }

        return tList;
    }

}
