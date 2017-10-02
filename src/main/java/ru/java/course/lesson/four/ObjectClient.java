package ru.java.course.lesson.four;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author dinyat
 * 02/10/2017
 */
public class ObjectClient {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try (Socket socket = new Socket("localhost", 8000)) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                DataObject object = new DataObject("Some data " + i);
                System.out.println("Sending object " + object);
                objectOutputStream.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
