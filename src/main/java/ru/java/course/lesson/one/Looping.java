package ru.java.course.lesson.one;

import java.util.Scanner;

/**
 * @author dinyat
 *         01/08/2017
 */
public class Looping {

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Пожалуйста, введите число:");
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("Zero");
            } else if (input % 2 == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }

            System.out.println("Продолжить исполнение?");
            run = scanner.nextBoolean(); // заменить на да/нет
        }

    }

}
