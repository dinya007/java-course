package ru.java.course.homework.two;

/**
 * @author dinyat
 * 19/09/2017
 */
public class OverdraftAccount extends Account {

    private final long overdraft;

    public OverdraftAccount(long amount, long overdraft) {
        super(amount);
        this.overdraft = overdraft;
    }

    @Override
    public boolean isSufficient(long amount) {
        long current = this.amount.get();
        return (current + overdraft - amount) >= 0;
    }
}
