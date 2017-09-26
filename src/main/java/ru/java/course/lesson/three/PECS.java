package ru.java.course.lesson.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dinyat
 * 26/09/2017
 */
public class PECS {

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>(Arrays.asList(5, 3, 4));

        printNumbers(list);
        addNumber(list, 6);
        printNumbers(list);
    }

    private static void printNumbers(List<? extends Number> list) {
        System.out.println("---");
        for (Number number : list) {
            System.out.println(number);
        }
        System.out.println("---");
    }

    private static void addNumber(List<? super Number> list, Number number) {
        list.add(number);
    }


}
