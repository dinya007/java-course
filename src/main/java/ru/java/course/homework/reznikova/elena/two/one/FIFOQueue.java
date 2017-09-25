package ru.java.course.homework.reznikova.elena.two.one;


import java.util.ArrayList;

public class FIFOQueue {
    ArrayList<String> queue;

    public FIFOQueue() {
        this.queue = new ArrayList<>();
    }

    public void add(String newElement) {
        this.queue.add(newElement);
    }

    public String get() {
        if (this.queue.size() == 0) {
            throw new NullPointerException("Очередь пуста!");
        } else {
            String temp = this.queue.get(0);
            this.queue.remove(0);
            return temp;
        }
    }

}
