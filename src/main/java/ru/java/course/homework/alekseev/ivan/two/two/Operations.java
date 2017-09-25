package ru.java.course.homework.alekseev.ivan.two.two;

public class Operations {

    public static void Transfer(Account from, Account to, int amount) {
        from.decreaseBalance(amount);
        to.increaseBalance(amount);
    }

}
