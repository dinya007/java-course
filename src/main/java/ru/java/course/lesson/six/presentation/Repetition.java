package ru.java.course.lesson.six.presentation;

public class Repetition {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread pingThread = new Thread(new PingThread());
        Thread pongThread = new Thread(new PongThread());

        pingThread.start();
        pongThread.start();
    }

    private static class PingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println("Ping");
                    System.out.println(System.currentTimeMillis());
                    flag = false;
                    try {
                        Thread.currentThread().sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private static class PongThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (!flag) {
                    System.out.println("Pong");
                    System.out.println(System.currentTimeMillis());
                    flag = true;
                }
            }
        }
    }

}
