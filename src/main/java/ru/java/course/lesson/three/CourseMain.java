package ru.java.course.lesson.three;

import java.util.Arrays;

/**
 * @author dinyat
 * 26/09/2017
 */
public class CourseMain {

    public static void main(String[] args) {
        System.out.println(Course.valueOf("MATH").getSemestr());
        System.out.println(Arrays.toString(Course.values()));
        Course.MATH.printName();
    }

}
