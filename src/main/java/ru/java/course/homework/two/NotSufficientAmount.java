package ru.java.course.homework.two;

/**
 * @author dinyat
 * 19/09/2017
 */
public class NotSufficientAmount extends RuntimeException {

    public NotSufficientAmount(Account account) {
        super("У аккаунта " + account + " не достаточно средств для перевода");
    }

}
