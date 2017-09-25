package ru.java.course.homework.reznikova.elena.two.two;


import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank(int numberOfAccounts) {
        this.accounts = new ArrayList<>(numberOfAccounts);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public void addAccount(Account newElement) {
        this.accounts.add(newElement);
    }

    public Account getAccount(int i) {
        return this.accounts.get(i);
    }

    public void transfer(int first, int second, float amount) throws NotSufficientAmount {
        this.accounts.get(first).spendMoney(amount);
        this.accounts.get(second).addMoney(amount);
    }
}
