package ru.java.course.lesson.six.presentation;

import ru.java.course.lesson.five.presentaion.Account;
import ru.java.course.lesson.five.presentaion.AccountService;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ConcurrentUtil {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Account john = new Account(0, 500_000, "John");
        Account kate = new Account(1, 500_000, "Kate");


        int threadCount = 4;
        int repeat = 100_000;

        shoot(new BankThread(john, kate, accountService), threadCount, repeat);
        System.out.println(john);
        System.out.println(kate);

    }

    private static class BankThread implements Runnable {

        private Account from;
        private Account to;
        private AccountService accountService;

        public BankThread(Account from, Account to, AccountService accountService) {
            this.from = from;
            this.to = to;
            this.accountService = accountService;
        }

        @Override
        public void run() {
//            for (int i = 0; i < 500_000; i++) {
                accountService.transfer(from, to, 1);
                accountService.transfer(to, from, 1);
//            }
        }
    }

    public static void shoot(Runnable runnable, int threadCount, int repeat) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    for (int j = 0; j < repeat; j++) {
                        runnable.run();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
            threads[i] = thread;
            thread.start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
