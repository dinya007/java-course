package ru.java.course.homework.reznikova.elena.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();

        Socket socket = new Socket("localhost", 8001);
        socket.setSoTimeout(1000);
        while (true) {
            ExecutorService es = Executors.newFixedThreadPool(1);

            es.submit(() -> {
                //System.out.println(name + ">");
                String text = scanner.nextLine();
                Message mes = new Message();
                mes.setUser(name);
                mes.setText(text);
                mes.Serial(socket);
            });

            Message inMsg = Message.getMessage(socket);
            if (inMsg != null) {
                System.out.println(inMsg.getUser() + ": " + inMsg.getText());
            }

        }
        //  socket.close();
    }


}
