package ru.java.course.lesson.four;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dinyat
 * 02/10/2017
 */
public class ObjectServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                DataObject dataObject = (DataObject) objectInputStream.readObject();
                System.out.println(dataObject);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
