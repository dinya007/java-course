package ru.java.course.homework.two;

/**
 * @author dinyat
 * 19/09/2017
 */
public class AccountService {

    public void transfer(Account from, Account to, long amount) {
        if (!from.isSufficient(amount)) {
            throw new NotSufficientAmount(from);
        }

        from.addAmount(-amount);
        to.addAmount(amount);
    }

}
