package ru.java.course.homework.reznikova.elena;

import java.util.ArrayList;
import java.util.Random;

public class HomeWorkTask2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(random.nextInt(11));
        }

        int countNegative = 0; //обертки стоит использовать только в коллекция типа ArrayList и т.д.
        while (countNegative < 6) {
            int i = random.nextInt(12);
            if (list.get(i) > 0) {
                list.set(i, list.get(i) * (-1));
                countNegative++;
            }
        }
        System.out.println("Результат:");
        for (Integer aList : list) {
            System.out.println(aList);
        }
    }
}
