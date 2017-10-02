package ru.java.course.lesson.four.socket;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author dinyat
 * 02/10/2017
 */
public class StringClient {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
//            try (Socket socket = new Socket("localhost", 8000)) {
//            try (Socket socket = new Socket("127.0.0.1", 8000)) {
            try (Socket socket = new Socket("77.88.19.41", 8000)) {
                TimeUnit.SECONDS.sleep(1);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String line = "Line " + i;
                System.out.println("Writing line: " + line);
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
            }

        }
    }

}
