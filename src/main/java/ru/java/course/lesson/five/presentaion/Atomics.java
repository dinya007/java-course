package ru.java.course.lesson.five.presentaion;

import java.util.concurrent.atomic.AtomicLong;

public class Atomics {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();

        System.out.println(atomicLong.getAndIncrement());
    }

}
