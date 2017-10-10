package ru.java.course.lesson.five.presentaion;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierExample {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        new BarrierThread(barrier).start();
        new BarrierThread(barrier).start();

    }

    private static class BarrierThread extends Thread {

        private CyclicBarrier barrier;

        private BarrierThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for barrier");
                barrier.await();
                System.out.println("Starting " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
