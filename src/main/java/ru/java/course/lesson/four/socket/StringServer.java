package ru.java.course.lesson.four.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dinyat
 * 02/10/2017
 */
public class StringServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client ip: " + socket.getInetAddress());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println(inputStream.readUTF());
            }
        }
    }

}
