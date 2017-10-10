package ru.java.course.lesson.five;

public class ThreadStart {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("Основной поток");

        Thread runnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Sleeping...");
                    Thread.currentThread().sleep(2000L);
                    System.out.println("Wake up");
                    System.out.println("Еще один поток");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        runnableThread.setDaemon(true);
        runnableThread.start();
    }



}
