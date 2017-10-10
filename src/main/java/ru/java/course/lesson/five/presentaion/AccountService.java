package ru.java.course.lesson.five.presentaion;

public class AccountService {

    public void transfer(Account from, Account to, long amount) {
        Object monitor1;
        Object monitor2;
        if (from.getId() < to.getId()) {
            monitor1 = from;
            monitor2 = to;
        } else {
            monitor1 = to;
            monitor2 = from;
        }
        synchronized (monitor1) {
//            System.out.println(Thread.currentThread().getName() + " synchronized on " + from);
            synchronized (monitor2) {
//                System.out.println(Thread.currentThread().getName() + " synchronized on " + to);
                if (from.getAmount() >= amount) {
                    from.setAmount(from.getAmount() - amount);
                    to.setAmount(to.getAmount() + amount);
                    return;
                }
                throw new IllegalStateException("Account " + from + " doesn't have enough money");
            }
        }
    }
}
