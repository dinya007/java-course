package ru.java.course.homework.alekseev.ivan.two.one;


import java.util.Arrays;

public class Fifo {

    private String[] data = new String[0];

    public void push(String element) {
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = element;
    }

    public String pull() {
        String str = data[0];
        data = Arrays.copyOfRange(data, 1, data.length);
        return str;
    }

    public boolean isEmpty() {
        if (data.length > 0) {
            return false;
        } else {
            return true;
        }
    }
}
