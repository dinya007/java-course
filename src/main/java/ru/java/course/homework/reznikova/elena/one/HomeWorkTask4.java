package ru.java.course.homework.reznikova.elena.one;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWorkTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer count;
            System.out.println("Введите целое положительное n:");
            while (true) {
                while (true) {
                    try {
                        count = Integer.parseInt(scanner.next());
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Это не целое число!");
                    }
                }
                if (count <= 0) {
                    System.out.println("N должно быть больше 0!");
                } else {
                    break;
                }
            }
            System.out.println("Последовательность Фибоначчи:");
            if (count == 1) {
                System.out.println("0");
            } else {
                ArrayList<Integer> result = new ArrayList<>(count + 1);
                result.add(0);
                result.add(1);
                for (int i = 2; i < count; i++) {
                    result.add(result.get(i - 1) + result.get(i - 2));
                }
                for (Integer aResult : result) {
                    System.out.println(aResult);
                }
            }
            System.out.println("Еще?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
