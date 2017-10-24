package ru.java.course.lesson.seven;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Server {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ArrayBlockingQueue<Message> ARRAY_BLOCKING_QUEUE = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        List<ClientConnection> connections = new ArrayList<>();

        Thread clientConnectionThread = new Thread(() -> {
            try {
                while (true) {
                    Socket client = serverSocket.accept();
                    ClientConnection clientConnection = new ClientConnection(client);
                    new Thread(clientConnection).start();
                    connections.add(clientConnection);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        clientConnectionThread.setDaemon(true);
        clientConnectionThread.start();

        new Thread(() -> {
            try {
                Message message = ARRAY_BLOCKING_QUEUE.take();
                for (ClientConnection connection : connections) {
                    String json = OBJECT_MAPPER.writeValueAsString(message);
                    DataOutputStream dataOutputStream = new DataOutputStream(connection.getSocket().getOutputStream());
                    dataOutputStream.writeUTF(json);
                    dataOutputStream.flush();
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static class ClientConnection implements Runnable {

        private final Socket socket;

        private ClientConnection(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                while (true) {
                    String packetData = dataInputStream.readUTF();
                    Message message = OBJECT_MAPPER.readValue(packetData, Message.class);
                    ARRAY_BLOCKING_QUEUE.add(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Socket getSocket() {
            return socket;
        }
    }

}
