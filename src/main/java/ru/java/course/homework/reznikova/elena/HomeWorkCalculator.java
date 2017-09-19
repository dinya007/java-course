package ru.java.course.homework.reznikova.elena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введи операцию, которую необходимо выполнить:");
            String operation = scanner.next();
            ArrayList<Float> params;
            if (operation.equals("+")) {
                params = getArguments();
                System.out.println("Ответ: " + (params.get(0) + params.get(1)));
            } else if (operation.equals("-")) {
                params = getArguments();
                System.out.println("Ответ: " + (params.get(0) - params.get(1)));
            } else if (operation.equals("*")) {
                params = getArguments();
                System.out.println("Ответ: " + (params.get(0) * params.get(1)));
            } else if (operation.equals("/")) {
                params = getArguments();
                while (params.get(1) == 0) {
                    System.out.println("Не буду делить на 0! Давай другой делитель:");
                    while (true) {
                        try {
                            params.set(1, Float.parseFloat(scanner.next()));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Это не число! Введи делитель повторно:");
                        }
                    }
                }
                float res = params.get(0) / params.get(1);
                System.out.println("Ответ: " + res);
            } else {
                System.out.println("Операция не введена");
            }
            System.out.println("Посчитаем еще?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static ArrayList<Float> getArguments() {
        ArrayList<Float> params = new ArrayList<>(Arrays.asList(Float.parseFloat("0"), Float.parseFloat("0")));
        System.out.println("Введите параметры:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            while (true) {
                try {
                    params.set(i, Float.parseFloat(scanner.next()));
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Это не число! Введи параметр " + (i + 1) + " повторно:");
                }
            }
        }
        return params;
    }
}
