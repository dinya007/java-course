package ru.java.course.lesson.four.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dinyat
 * 03/10/2017
 */
public class PresentationServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            System.out.println("Waiting for connection...");
            try (Socket clientSocket = serverSocket.accept();
                 DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {
                String name = dataInputStream.readUTF();
                System.out.println("Привет, " + name + "!");
            }
        }
    }

}
