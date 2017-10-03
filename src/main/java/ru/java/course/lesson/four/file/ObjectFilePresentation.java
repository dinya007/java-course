package ru.java.course.lesson.four.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author dinyat
 * 03/10/2017
 */
public class ObjectFilePresentation {

    public static void main(String[] args) {
        DataObject data = new DataObject("Some data");


        String path = "/Users/dinyat/Desktop/object_file.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))
        ) {

            oos.writeObject(data);

            oos.flush();

            DataObject dataObject = (DataObject) ois.readObject();
            System.out.println(dataObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
