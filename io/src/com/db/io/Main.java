package com.db.io;

import java.io.*;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        File file = new File("file.dat");
        if (file.exists()) {
            System.out.println("File already exists.");
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int x = 257;
            fileOutputStream.write(x);
            fileOutputStream.write(5);
            fileOutputStream.write(7);
            byte[] bytes = new byte[8];
            bytes[0] = 2;
            bytes[1] = 9;
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException exception) {
            System.err.println("(Write) FileNotFoundException: " + exception.getMessage());
//                exception.printStackTrace();
        } catch (IOException exception) {
            System.err.println("(Write) IOException: " + exception.getMessage());
        }

        try {
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(file);
//            byte[] readBytes = new byte[4];
//            short noOfBytesRead = (short)fileInputStream.read(readBytes);
            int readByte = fileInputStream.read();
            System.out.println("Read byte: " + readByte);
//            if (noOfBytesRead >= 4) {
//                System.out.println("Read " + noOfBytesRead);
//                for (int i = 0; i < noOfBytesRead; i++) {
//                    System.out.print(readBytes[i] + " ");
//                }
//                System.out.println();
//                int readNumber = fromByteArray(readBytes);
//                System.out.println("Int number is " + readNumber);
//            }

        } catch (FileNotFoundException exception) {
            System.err.println("(Read) FileNotFoundException: " + exception.getMessage());
        }
        catch (IOException exception) {
            System.err.println("(Read) IOException: " + exception.getMessage());
        }

        House[] houses = new House[5];
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < houses.length; i++) {
                houses[i] = new House("house " + i);
                double makeLatNegative = Math.random();
                double actualLat = Math.random() * 90;
                double actualLong = Math.random() * 110;
                houses[i].setLat((float) (makeLatNegative < 0.5 ? -actualLat : actualLat)); // [0; 1) => [0; 90) [-90; 90)
                houses[i].set_long((float) actualLong);
                objectOutputStream.writeObject(houses[i]);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            for (int i = 0; i < houses.length; i++) {
                House something = (House)objectInputStream.readObject();
                System.out.println("Read house: " + something);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }




    }

    static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
}
