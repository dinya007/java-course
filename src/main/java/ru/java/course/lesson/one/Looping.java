package ru.java.course.lesson.one;

/**
 * @author dinyat
 * 01/08/2017
 */
public class Looping {


    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = {1, 2};
        int[] array = new int[]{1, 2, 3};

        System.out.println(array1.length);
        System.out.println(array2.length);
        System.out.println(array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
