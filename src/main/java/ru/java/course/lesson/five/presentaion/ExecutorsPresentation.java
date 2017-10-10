package ru.java.course.lesson.five.presentaion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsPresentation {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                System.out.println("Start " + Thread.currentThread().getName());
                Thread.currentThread().sleep(100L);
                System.out.println("End "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()),
                0, 1, TimeUnit.SECONDS);


    }

}
