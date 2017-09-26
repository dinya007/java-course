package ru.java.course.lesson.three;

import java.util.Arrays;
import java.util.List;

/**
 * @author dinyat
 * 26/09/2017
 */
public class PECS {

    public static void main(String[] args) {
        List<? extends Number> list = Arrays.asList(5, 3, 4);

        printNumbers(list);
    }

    private static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    private static void addNumber(List<? super Number> list, Number number) {
        list.add(number);
    }


}
