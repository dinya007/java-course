package ru.java.course.lesson.four.file;

import ru.java.course.lesson.four.DataObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author dinyat
 * 02/10/2017
 */
public class FileWritingExample {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/dinyat/Desktop/new_file.txt");
            file.createNewFile();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new DataObject("Data 1"));
            objectOutputStream.writeObject(new DataObject("Data 2"));
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());

            file.delete();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
