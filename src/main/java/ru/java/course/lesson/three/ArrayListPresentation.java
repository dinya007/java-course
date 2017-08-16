package ru.java.course.lesson.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author dinyat
 * 15/08/2017
 */
public class ArrayListPresentation {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(3);

        System.out.println(sum(list));
        System.out.println(max(list));

        System.out.println(list);

        Collections.sort(list, new IntegerComparator());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }.reversed());
        System.out.println(list);
    }

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            } else if (o2 > o1) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            sum += a;
        }
        return sum;
    }

    private static int max(ArrayList<Integer> list) {
        int max = 0;
        for (int element : list) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

}
