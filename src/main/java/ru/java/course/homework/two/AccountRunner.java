package ru.java.course.homework.two;

/**
 * @author dinyat
 * 19/09/2017
 */
public class AccountRunner {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();

//        Account account1 = new SimpleAccount(100L);
//        Account account2 = new SimpleAccount(0L);

        Account account1 = new OverdraftAccount(100L, 10);
        Account account2 = new SimpleAccount(0L);

        accountService.transfer(account1, account2, 50);
        accountService.transfer(account1, account2, 51);
        System.out.println(account1);
        System.out.println(account2);
    }

}
