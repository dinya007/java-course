package ru.java.course.lesson.five.presentaion;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
