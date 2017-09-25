package ru.java.course.homework.reznikova.elena.one;

import java.util.Scanner;

public class HomeWorkTask3 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите целое положительное n:");
            Integer number;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                while (true) {
                    try {
                        number = Integer.parseInt(scanner.next());
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Это не целое число!");
                    }
                }
                if (number <= 0) {
                    System.out.println("N должно быть больше 0!");
                } else {
                    break;
                }
            }
            int d = (int) Math.ceil(Math.sqrt(number));
            String answer = "Простое";
            for (int i = 2; i < d + 1; i++) {
                if (number % i == 0) {
                    answer = "Непростое";
                    break;
                }
            }
            System.out.println(answer);
            System.out.println("Еще?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
