package ru.java.course.homework.reznikova.elena;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        /*
        System.out.println("Hello world!");             //вывод текста

        String variable = new String("Hello");          //вывод суммы строк
        variable = variable + " Lena!";
        System.out.println(variable);


        Scanner scanner = new Scanner(System.in);       //ввод текста с консоли
        String name = scanner.next();
        System.out.println("Привет " + name);


        Scanner scanner1 = new Scanner(System.in);      //условие
        int number = scanner1.nextInt();
        if (number % 2 == 0)
        {
            System.out.println("четное!");
        }
        else
            System.out.println("нетушки!");


        Scanner scanner2 = new Scanner(System.in);      //цикл
        int number2;
        for (int i = 0; i <= 3; i++) {
            number2 = scanner2.nextInt();
            if (number2 % 2 == 0) {
                System.out.println("четное!");
            } else
                System.out.println("нетушки!");
        }


        Scanner scanner3 = new Scanner(System.in);      //бесконечный цикл и выход из него
        int number3;
        while (true) {
            System.out.println("Введи число:");
            number3 = scanner3.nextInt();
            if (number3 % 2 == 0) {
                System.out.println("четное!");
            } else
                System.out.println("нетушки!");
            System.out.println("Продолжим?");
            String resp = scanner3.next();
            if (resp.equalsIgnoreCase("нет"))
                 break;
        }
        */

        Scanner scanner4 = new Scanner(System.in);      //вынесли в отдельную функцию проверку на четность - public static String categorize(int input)
        while (true) {
            System.out.println("Введи число:");
            System.out.println(categorize(scanner4.nextInt()));
            System.out.println("Продолжим?");
            String resp = scanner4.next();
            if (resp.equalsIgnoreCase("нет"))
                break;
        }

    }

    public static String categorize(int input)
    {
        if (input == 0 )
            return "это же нолик!";
        else if (input % 2 == 0) {
            return "четное!";
        } else
            return "нечетное!";
    }
}
