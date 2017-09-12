package ru.java.course.lesson.one;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int previous = 0;
        int current = 1;
        System.out.println(previous);
        System.out.println(current);
        for (int i = 0; i < size; i++) {
            current = current + previous;
            previous = current - previous;
            System.out.println(current);
        }

    }

}
