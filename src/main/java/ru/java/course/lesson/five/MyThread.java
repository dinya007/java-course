package ru.java.course.lesson.five;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Новый поток");
    }
}
