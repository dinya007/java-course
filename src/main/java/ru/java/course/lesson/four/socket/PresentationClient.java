package ru.java.course.lesson.four.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author dinyat
 * 03/10/2017
 */
public class PresentationClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("95.108.185.82", 8000);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF("Денис");

        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }

}
