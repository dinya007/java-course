package ru.java.course.homework.reznikova.elena.three.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task2_1 {

    public static void main(String[] args) {
        System.out.println("Введите массив:");
//        ArrayList<Integer> array = FillArray();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0, 1, 4, 13, 5, 3, 7, 2));
        System.out.println("Вы ввели числа:");
        System.out.println(array);
        System.out.println("Введите число");
//        int number = NumberInput("число"); //имена методов начинаются со строчной буквы и пишутся в camelCase
        int number = 3; //имена методов начинаются со строчной буквы и пишутся в camelCase
        array.sort(Integer::compare); //сортирует массив так, что все элементы в нем считаются равными
        System.out.println(array);


        ArrayList<Pair> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int el = array.get(i);
            int diff = number - el;
            if (diff < el) {
                break;
            } else {
                if (Collections.binarySearch(array, diff) != -1) {
                    result.add(new Pair(el, diff));
                }
            }
        }
        System.out.println(result);

    }

    public static int NumberInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите " + message + " повторно:");
            }
        }
        return number;
    }

    public static ArrayList<Integer> FillArray() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        while (true) {
            Integer n = NumberInput("элемент массива");
            if (array.contains(n)) {
                System.out.println("Такое число в массиве есть число, повторите ввод:");
                continue;
            } else {
                array.add(n);
                System.out.println("Добавить в массив еще число?");
                String resp = scanner.next();
                if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                    break;
                }
                System.out.println("Введите число:");
            }
        }
        return array;
    }
}
