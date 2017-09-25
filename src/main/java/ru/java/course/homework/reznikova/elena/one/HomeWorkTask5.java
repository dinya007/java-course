package ru.java.course.homework.reznikova.elena.one;

import java.util.ArrayList;
import java.util.Random;

public class HomeWorkTask5 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list1 = new ArrayList<>(20);
        ArrayList<Integer> list2 = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list1.add(random.nextInt(101));
            list2.add(random.nextInt(101));
        }
        System.out.println("Массив 1:");
        for (Integer aList : list1) {
            System.out.println(aList);
        }
        System.out.println("Массив 2:");
        for (Integer aList : list2) {
            System.out.println(aList);
        }
        ArrayList<Integer> result = new ArrayList<>(20);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (list1.get(i).equals(list2.get(j)) && !result.contains(list2.get(j))) {
                    result.add(list2.get(j));
                }
            }
        }

        System.out.println("Результат:");
        for (Integer aResult : result) {
            System.out.println(aResult);
        }
    }
}
