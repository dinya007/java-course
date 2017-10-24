package ru.java.course.lesson.seven;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Charset encoding = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        Thread sendMessageThread = new Thread(() -> {
            try {
                while (true) {
//                    System.out.println("Введите сообщение: ");
                    String stringMessage = scanner.nextLine();
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(OBJECT_MAPPER.writeValueAsString(new Message(name, stringMessage)));
                    dataOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        sendMessageThread.start();

        Thread inputMessagesThread = new Thread(() -> {
            try {
                while (true) {
                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    Message message = OBJECT_MAPPER.readValue(dataInputStream.readUTF(), Message.class);
                    System.out.println(message.getUser() + " : " + message.getMessage());
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        });
        inputMessagesThread.setDaemon(true);
        inputMessagesThread.start();
    }

}
