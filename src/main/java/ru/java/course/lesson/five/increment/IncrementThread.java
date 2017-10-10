package ru.java.course.lesson.five.increment;

public class IncrementThread extends Thread {

    private boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();

        Thread.currentThread().sleep(1000L);

        incrementThread.keepRunning = false;
        System.out.println("Set false");
    }


    @Override
    public void run() {
        long count = 0;
        while (keepRunning) {
            ++count;
        }
        System.out.println("Count: " + count);
    }


}