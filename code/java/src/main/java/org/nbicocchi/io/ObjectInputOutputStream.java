package org.nbicocchi.io;

import org.nbicocchi.utils.Student;
import org.nbicocchi.utils.Utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = Paths.get(Utils.ooprogrammingdir(), "objectstream.bin").toString();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));

        List<Student> lin = new ArrayList<>();
        lin.add(new Student("Nicola", "Bicocchi", 28.0));
        lin.add(new Student("Mario", "Rossi", 27.0));
        lin.add(new Student("Luca", "Bianchi", 29.0));
        objectOutputStream.writeObject(lin);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        @SuppressWarnings("unchecked")
        List<Student> lout = (List<Student>) objectInputStream.readObject();
        objectInputStream.close();

        for (Student s : lout) {
            System.out.println(s);
        }
    }
}
