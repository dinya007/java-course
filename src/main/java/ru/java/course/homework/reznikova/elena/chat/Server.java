package ru.java.course.homework.reznikova.elena.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Server {

    public Socket waitConnection(ServerSocket serverSocket) {
        try {
            Socket clientSocket = serverSocket.accept();
            clientSocket.setSoTimeout(1000);
            return clientSocket;
        } catch (IOException e) {
            //System.out.println("Accept failed:\t" + e.getMessage());
        }
        return null;
    }
/*
    public Message getMessage(Socket clientSocket)
    {
        try
        {
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Message) un.unmarshal(new StringReader(dataInputStream.readUTF()));

        }
        catch (Exception e) {
         //   System.out.println("Accept failed:\t" + e.getMessage());
        }
        return null;
    }*/

    public void pushToFile(Message msg) throws IOException {
        FileWriter f = new FileWriter(new File("text.txt"), true);
        f.write(msg.toString() + '\n');
        f.close();
    }

    public void Main() throws IOException {
        System.out.println("Server started");
        final int timeout = 1;
        int outCount = 0;
        ArrayList<Socket> connections = new ArrayList<>();
        ArrayList<Message> messages = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(8001);
        serverSocket.setSoTimeout(1000);
        while (true) {
            //ожидание нового подключения
            Socket s = waitConnection(serverSocket);
            if (s != null) {
                connections.add(s);
            }

            //получение сообщений от всех подключений
            for (int i = 0; i < connections.size(); i++) {
                Message m = Message.getMessage(connections.get(i));
                if (m != null) {
                    System.out.println(m.getUser() + ": " + m.getText());

                    for (int j = 0; j < connections.size(); j++) {
                        m.Serial(connections.get(j));

                    }

                    m.setTimestamp(LocalDateTime.now());
                    messages.add(m);
                }
            }

            //выгрузка сообщений дольше минуты в файл
            for (int i = outCount; i < messages.size(); i++) {
                if (!LocalDateTime.now().minus(timeout, ChronoUnit.MINUTES).isBefore(messages.get(i).getTimestamp())) {
                    pushToFile(messages.get(i));
                    outCount++;
                }
            }


        }


    }

}
