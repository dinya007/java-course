package ru.java.course.lesson.one;

import java.util.Scanner;

public class IfClauses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        if (input == 0) {
            System.out.println("Zero");
        } else if (input % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        input = scanner.nextInt();

        switch (input) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break; // remove
            default:
                System.out.println("Default");
        }

    }

}
