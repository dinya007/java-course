package ru.java.course.homework.alekseev.ivan.two.two;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    void increaseBalance(int amount) {
        this.balance = this.balance + amount;
    }

    void decreaseBalance(int amount) {
        this.balance = this.balance - amount;
    }
}
