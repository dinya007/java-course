package ru.java.course.lesson.seven.presentation;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private final int capacity = 1;
    private int size = 0;
    private List<T> list = new ArrayList<>();

    public void push(T element) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " got lock");
            while (size >= capacity) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " adding element");
            list.add(element);
            ++size;
        }
    }

    public synchronized T take() {
        System.out.println(Thread.currentThread().getName() + " took element");
        T result = list.get(0);
        --size;
        this.notifyAll();
        return result;
    }


}
