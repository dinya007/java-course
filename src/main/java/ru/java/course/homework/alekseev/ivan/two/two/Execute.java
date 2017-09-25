package ru.java.course.homework.alekseev.ivan.two.two;

import java.util.Scanner;

public class Execute {

    public static void main(String[] args) {

        Account acc1 = new CredAccount(100,100);
        Account acc2 = new DebAccount(100);

        System.out.println("Acc1: " + acc1.getBalance());
        System.out.println("Acc1: " + acc2.getBalance());

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите сумму перевода: ");
        int amount = scan.nextInt();

        Operations.Transfer(acc1, acc2, amount);

        System.out.println("Acc1: " + acc1.getBalance());
        System.out.println("Acc1: " + acc2.getBalance());

    }
}
