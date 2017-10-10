package ru.java.course.lesson.five.account;

public class AccountService {

    public void transfer(Account from, Account to, long amount) {
        try {
            synchronized (from) {
                System.out.println(Thread.currentThread().getName() + " synchronized on from");
                Thread.currentThread().sleep(50L);
                synchronized (to) {
                    System.out.println(Thread.currentThread().getName() + " synchronized on to");
                    Thread.currentThread().sleep(50L);
                    if (from.getAmount() >= amount) {
                        Thread.currentThread().sleep(5L);
                        from.setAmount(from.getAmount() - amount);
                        to.setAmount(to.getAmount() + amount);
                        return;
                    }
                    throw new IllegalStateException("Account from doesn't have enough money");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
