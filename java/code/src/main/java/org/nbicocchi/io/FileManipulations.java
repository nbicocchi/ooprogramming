package org.nbicocchi.io;

import org.nbicocchi.utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManipulations {
    public static void main(String[] args) throws IOException {
        System.out.println("Copying...");
        Files.copy(Paths.get("src/main/resources/images/shuttle.jpg"),
                Paths.get(Utils.ooprogrammingdir(), "shuttle.jpg"), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Moving...");
        Files.move(Paths.get(Utils.ooprogrammingdir(), "shuttle.jpg"),
                Paths.get(Utils.ooprogrammingdir(), "shuttle_copy.jpg"), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Deleting...");
        Files.delete(Paths.get(Utils.ooprogrammingdir(), "shuttle_copy.jpg"));
    }

}
