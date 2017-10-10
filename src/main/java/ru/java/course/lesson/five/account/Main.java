package ru.java.course.lesson.five.account;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1_000L);
        Account account2 = new Account(0);
        AccountService accountService = new AccountService();

        TransferThread transferThread1 = new TransferThread(account1, account2, accountService);
        TransferThread transferThread2 = new TransferThread(account2, account1, accountService);

        transferThread1.start();
        transferThread2.start();

        transferThread1.join();
        transferThread2.join();

        System.out.println(account1.getAmount());
        System.out.println(account2.getAmount());
    }

    private static class TransferThread extends Thread {

        private final Account from;
        private final Account to;
        private final AccountService accountService;

        private TransferThread(Account from, Account to, AccountService accountService) {
            this.from = from;
            this.to = to;
            this.accountService = accountService;
        }


        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                accountService.transfer(from, to, 1);
            }
        }
    }

}
