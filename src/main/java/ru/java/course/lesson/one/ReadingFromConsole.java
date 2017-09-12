package ru.java.course.lesson.one;

import java.util.Scanner;

public class ReadingFromConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        System.out.println(scanner.hasNext());
        scanner.close();
        long number = scanner.nextLong();

        System.out.println(string);
        System.out.println(number);
    }

}
