package ru.java.course.lesson.five.presentaion;

public class ThreadInterrupt {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.currentThread().sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++count;
                System.out.println(count);
            }
            System.out.println("Interrupted");
        });

        thread.start();
        Thread.currentThread().sleep(100L);
        thread.interrupt();

    }


}
