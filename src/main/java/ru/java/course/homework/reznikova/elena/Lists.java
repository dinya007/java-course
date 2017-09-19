package ru.java.course.homework.reznikova.elena;

import java.util.ArrayList;
import java.util.Arrays;

public class Lists {
    public static void main(String[] args) {
        /*
        ArrayList <Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        for (Integer aList : list) {            //можно заменить for (int i = 0; i < list.size(); i++) на for (Integer aList : list) - (foreach)
            System.out.println(aList);
        }
        */
        ArrayList <Integer> list1 = new ArrayList<>(Arrays.asList(1,17,3,4,17));
        System.out.println("Максимальное число массива: " + getMax(list1));


    }

    public static int getMax(ArrayList <Integer> list) {
        int max = list.get(0);
        for (Integer aList : list) {
            if (max < aList)
                max = aList;
        }
       return max;
    }
}
