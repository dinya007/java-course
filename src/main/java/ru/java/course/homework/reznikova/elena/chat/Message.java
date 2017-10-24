package ru.java.course.homework.reznikova.elena.chat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;


@XmlRootElement(name = "Message")
@XmlType(propOrder = {"user", "text", "timestamp"})
public class Message {

    private String user;
    private String text;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", text='" + text + '\'' +
                ", time=" + timestamp +
                '}';
    }

    public void Serial(Socket socket) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            JAXBContext context = JAXBContext.newInstance(Message.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            dataOutputStream.writeUTF(writer.toString());
            dataOutputStream.flush();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Message getMessage(Socket clientSocket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Message) un.unmarshal(new StringReader(dataInputStream.readUTF()));

        } catch (Exception e) {
            //     System.out.println("Accept failed:\t" + e.getMessage());
        }
        return null;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
