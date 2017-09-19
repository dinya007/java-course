package ru.java.course.homework.two;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dinyat
 * 19/09/2017
 */
public abstract class Account {

    protected AtomicLong amount;

    public Account(long amount) {
        this.amount = new AtomicLong(amount);
    }

    public abstract boolean isSufficient(long amount);

    public void addAmount(long amount) {
        this.amount.addAndGet(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
            "amount=" + amount +
            '}';
    }
}
