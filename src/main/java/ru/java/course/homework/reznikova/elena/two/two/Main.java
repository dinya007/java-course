package ru.java.course.homework.reznikova.elena.two.two;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = fillBank();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Сделать перевод?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("С какого счета? У нас есть счета:");
            for (int j = 0; j < bank.getNumberOfAccounts(); j++) {
                System.out.println("Счет №" + (j + 1) + ", владелец " + bank.getAccount(j).secondName + " баланс: " + bank.getAccount(j).balance);
            }
            int first = accountIdInput(bank.getNumberOfAccounts());
            System.out.println("На какой счет:");
            int second = accountIdInput(bank.getNumberOfAccounts());
            System.out.println("Какую сумму перевести:");
            float amount = floatInput("сумму");
            try {
                bank.transfer(first - 1, second - 1, amount);
                System.out.println("Перевод выполнен успешно");
            } catch (NotSufficientAmount e) {
                System.out.println("Перевод не выполнен. На счету " + first + " недостаточно средств.");
            }

            /*if (bank.transfer(first-1, second-1, amount))
            {
                System.out.println("Перевод выполнен успешно");
            }
            else
            {
                System.out.println("Перевод не выполнен. На счету " + first + " недостаточно средств.");
            }*/

        }
    }

    private static Bank fillBank() {
        System.out.println("Введите количество счетов банка:");
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            number = numberInput("количество счетов");
            if (number <= 1) {
                System.out.println("В банке должно быть хотя бы два счета, ведите их число снова:");
            } else {
                break;
            }
        }
        Bank bank = new Bank(number);
        for (int i = 0; i < number; i++) {
            System.out.println("Фамилия владельца счета №" + (i + 1));
            String surname = scanner.next();
            System.out.println("Имя владельца счета №" + (i + 1));
            String name = scanner.next();
            System.out.println("Баланс счета №" + (i + 1));
            float balance = floatInput("баланс");
            System.out.println("Позволять овердрафт? 1 - да, 0 - нет");
            while (true) {
                int op = numberInput("вариант");
                if (op == 0) {
                    bank.addAccount(new Account(i + 1, name, surname));
                    break;
                } else if (op == 1) {
                    System.out.println("Введите сумму овердрафта");
                    float limit = floatInput("сумму");
                    bank.addAccount(new AccountWithOverdraft(i + 1, name, surname, limit));
                    break;
                } else {
                    System.out.println("Введите 1 или 0");
                }
            }
            bank.getAccount(i).addMoney(balance);
        }
        return bank;
    }


    private static int accountIdInput(int maxNumber) {
        Scanner scanner = new Scanner(System.in);
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.next());
                if (id > maxNumber) {
                    System.out.println("Такого счета нет, введите повторно:");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Это не число, введите повторно:");
            }
        }
        return id;
    }

    public static int numberInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите " + message + " повторно:");
            }
        }
        return number;
    }

    public static float floatInput(String message) {
        Scanner scanner = new Scanner(System.in);
        float number;
        while (true) {
            try {
                number = Float.parseFloat(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите " + message + " повторно:");
            }
        }
        return number;
    }
}
