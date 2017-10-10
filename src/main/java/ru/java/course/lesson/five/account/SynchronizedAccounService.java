package ru.java.course.lesson.five.account;

public class SynchronizedAccounService {

    public synchronized void transfer(Account from, Account to, long amount) {
        try {
            if (from.getAmount() >= amount) {
                Thread.currentThread().sleep(5L);
                from.setAmount(from.getAmount() - amount);
                to.setAmount(to.getAmount() + amount);
                return;
            }
            throw new IllegalStateException("Account from doesn't have enough money");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
