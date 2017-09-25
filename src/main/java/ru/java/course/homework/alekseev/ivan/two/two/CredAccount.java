package ru.java.course.homework.alekseev.ivan.two.two;


public class CredAccount extends Account{

    private int limit;

    public CredAccount(int balance, int limit) {
        super(balance);
        this.limit = limit;
    }

    void decreaseBalance(int amount) {

        if (this.getBalance() + limit >= amount) {
            super.decreaseBalance(amount);
        } else {
            throw new NotSufficientAmount();
        }

    }
}
