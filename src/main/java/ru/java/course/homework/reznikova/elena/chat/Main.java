package ru.java.course.homework.reznikova.elena.chat;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Server s = new Server();
        try {
            s.Main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
