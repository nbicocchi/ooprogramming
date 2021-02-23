package org.nbicocchi.io.exercises;

import org.nbicocchi.utils.Student;
import org.nbicocchi.utils.Utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Scrivere una classe dotata di 4 metodi pubblici:
 * <p>
 * 1) getStudent che legge da tastiera i campi necessari (su una sola linea,
 * separati da virgole) a descrivere uno studente (nome,cognome,anno imm.,media)
 * e ritorna un oggetto studente (vedi Scanner);
 * <p>
 * 2) storeText che accetta un riferimento a studente e un nome di file e salva
 * sul file una rappresentazione testuale dello studente (vedi BufferedWriter);
 * <p>
 * 3) storeBinary che accetta un riferimento a studente e un nome di file e
 * salva sul file una rappresentazione binaria dello studente (vedi
 * DataOutputStream);
 * <p>
 * 4) storeObject che accetta un riferimento a studente e un nome di file e
 * salva sul file una rappresentazione serializzata dello studente (vedi
 * ObjectOutputStream);
 * <p>
 * La classe prodotta deve funzionare con il main sottostante.
 *
 * @author Nicola Bicocchi
 */
public class FileStorage {
    public static void main(String[] args) {
        FileStorage manager = new FileStorage();
        Student student = manager.generateStudent();

        try {
            manager.saveText(student, Paths.get(Utils.ooprogrammingdir(), "student.bin").toString());
            manager.saveBin(student, Paths.get(Utils.ooprogrammingdir(), "student.txt").toString());
            manager.saveObj(student, Paths.get(Utils.ooprogrammingdir(), "student.obj").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student generateStudent() {
        System.out.println("Insert a student (e.g., name,surname,average): ");
        Scanner scr = new Scanner(System.in);
        String[] fields = scr.nextLine().split(",");
        scr.close();
        return new Student(fields[0], fields[1], Double.parseDouble(fields[2]));
    }

    public void saveText(Student s, String filename) throws IOException {
        String str = s.getName() + ',' + s.getLastname() + ',' + s.getAverage() + '\n';
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
        out.write(str);
        out.close();
        System.out.println("[OK] Saved as text file");
    }

    public void saveBin(Student s, String filename) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
        out.writeChars(s.getName());
        out.writeChars(s.getLastname());
        out.writeDouble(s.getAverage());
        out.close();
        System.out.println("[OK] Saved as binary file");
    }

    public void saveObj(Student s, String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(s);
        out.close();
        System.out.println("[OK] Saved as object file");
    }
}
