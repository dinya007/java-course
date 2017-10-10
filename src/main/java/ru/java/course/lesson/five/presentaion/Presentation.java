package ru.java.course.lesson.five.presentaion;

public class Presentation {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread newThread = new Thread(() -> {
            try {
                System.out.println("Sleeping..");
                Thread.currentThread().sleep(1000L);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        newThread.setDaemon(true);
        newThread.start();
    }

}
