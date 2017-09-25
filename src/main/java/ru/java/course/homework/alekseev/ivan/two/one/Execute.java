package ru.java.course.homework.alekseev.ivan.two.one;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Execute {

    public static void main(String[] args) throws InterruptedException {

        Fifo firstQueue = new Fifo();

        firstQueue.push("One");
        firstQueue.push("Two");
        firstQueue.push("Three");

        while (!firstQueue.isEmpty()) {
            System.out.println("q1: " + firstQueue.pull());
        }

        Fifo secondQueue = new FifoTime(3, ChronoUnit.SECONDS);

        //Заполняем в течении 5 секунд, 2 должны протухнуть
        for (int i = 0; i < 5; i++) {

            secondQueue.push("El " + (i + 1) + ". Date/time: " + LocalDateTime.now().toString());

            TimeUnit.SECONDS.sleep(1);
        }

        while (!secondQueue.isEmpty()) {
            System.out.println("secondQueue: " + secondQueue.pull());
        }

        System.out.println(new FifoTime(1, ChronoUnit.DECADES).pull());
        System.out.println(new Fifo().pull());

    }
}
