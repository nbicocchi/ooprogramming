package org.nbicocchi.io;

import org.nbicocchi.utils.Utils;

import java.io.*;
import java.nio.file.Paths;

public class DataInputOutputStream {
    public static void main(String[] args) throws IOException {
        String filename = Paths.get(Utils.ooprogrammingdir(), "data_stream.bin").toString();
        write_types(filename);
        read_bytes(filename);
        read_types(filename);
    }

    // Write primitives to an output file
    public static void write_types(String filename) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

        out.writeByte(0);
        out.writeShort(65535); // -1
        out.writeInt(0xABCD);
        out.writeLong(0x12344567); // JDK 7 syntax
        out.writeFloat(11.22f);
        out.writeDouble(55.66);
        out.writeBoolean(true);
        out.writeBoolean(false);

        String message = "Hello World!";
        out.writeInt(message.length());
        for (int i = 0; i < message.length(); i++) {
            out.writeChar(message.charAt(i));
        }
        out.writeChars(message);
        out.writeBytes(message);
        out.flush();
        out.close();
    }

    // Read raw bytes and print in Hex
    public static void read_bytes(String filename) throws IOException {
        int inByte;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));

        while ((inByte = in.read()) != -1) {
            System.out.printf("%02X ", inByte); // Print Hex codes
        }
        System.out.printf("%n%n");
        in.close();
    }

    // Read primitives types
    public static void read_types(String filename) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

        System.out.println("byte:    " + in.readByte());
        System.out.println("short:   " + in.readShort());
        System.out.println("int:     " + in.readInt());
        System.out.println("long:    " + in.readLong());
        System.out.println("float:   " + in.readFloat());
        System.out.println("double:  " + in.readDouble());
        System.out.println("boolean: " + in.readBoolean());
        System.out.println("boolean: " + in.readBoolean());

        int messageLength = in.readInt();
        System.out.println("int:     " + messageLength);

        System.out.print("char:    ");
        for (int i = 0; i < messageLength; i++) {
            System.out.print(in.readChar());
        }
        System.out.println();

        System.out.print("chars:   ");
        for (int i = 0; i < messageLength; i++) {
            System.out.print(in.readChar());
        }
        System.out.println();

        System.out.print("bytes:   ");
        for (int i = 0; i < messageLength; i++) {
            System.out.print((char) in.readByte());
        }
        System.out.println();
        in.close();
    }
}