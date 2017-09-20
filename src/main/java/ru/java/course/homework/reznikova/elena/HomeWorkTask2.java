package ru.java.course.homework.reznikova.elena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWorkTask2 {
    public static void main(String[] args) {
        while (!doTask().contains(0)) {

        }
    }

    private static List<Integer> doTask() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(random.nextInt(10) + 1);
        }
        Integer countNegative = 0;
        while (countNegative < 6) {
            int i = random.nextInt(12);
            if (list.get(i) > 0) {
                list.set(i, list.get(i) * (-1));
                countNegative++;
            }
        }
        System.out.println("Результат: " + list);
        return list;
    }
}
