package ru.java.course.lesson.one;

import java.util.Scanner;

public class Looping {

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Пожалуйста, введите число:");
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt();
            System.out.println(categorize(input));


            System.out.println("Продолжить исполнение?");
            String doNext = scanner.next(); // заменить на да/нет

            if ("нет".equalsIgnoreCase(doNext)) {
                break;
            }

        }

    }

    private static String categorize(int input) {
        String result;
        if (input == 0) {
            result = "Zero";
        } else if (input % 2 == 0) {
            result = "Even";
        } else {
            result = "Odd";
        }
        return result;
    }


}
