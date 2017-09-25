package ru.java.course.homework.two;

/**
 * @author dinyat
 * 19/09/2017
 */
public class SimpleAccount extends Account {

    public SimpleAccount(long amount) {
        super(amount);
    }

    @Override
    public boolean isSufficient(long amount) {
        long current = this.amount.get();
        return (current - amount) >= 0;
    }

}
