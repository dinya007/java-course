package ru.java.course.homework.alekseev.ivan.two.two;


public class DebAccount extends Account {

    public DebAccount(int balance) {
        super(balance);
    }

    void decreaseBalance(int amount) {

        if (this.getBalance() >= amount) {
            super.decreaseBalance(amount);
        } else {
            throw new NotSufficientAmount();
        }

    }
}
