package org.nbicocchi.io.exercises.trains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextStorage extends Storage {

    public TextStorage(String filename) {
        super(filename);
    }

    @Override
    public void store(List<Train> tList, boolean append) throws IOException {
        FileWriter out = new FileWriter(this.filename, append);

        for (Train t : tList) {
            out.write(t.toString() + "\n");
        }
        out.close();
    }

    @Override
    public List<Train> load() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(this.filename));
        ArrayList<Train> tList = new ArrayList<>();

        Train t;
        while ((t = Train.readChars(in)) != null) {
            tList.add(t);
        }

        return tList;
    }
}
