package ru.java.course.lesson.five.presentaion;

public class Account {

    private long id;
    private long amount;
    private String name;

    public Account(long id, long amount, String name) {
        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
