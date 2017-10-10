package ru.java.course.lesson.five.presentaion;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new CountDownLatchThread(countDownLatch).start();
        new CountDownLatchThread(countDownLatch).start();
        new CountDownLatchThread(countDownLatch).start();

        countDownLatch.await();
        System.out.println("Done");

    }


    private static class CountDownLatchThread extends Thread {
        private CountDownLatch countDownLatch;

        private CountDownLatchThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("Counting down " + getName());
            countDownLatch.countDown();
        }
    }
}
