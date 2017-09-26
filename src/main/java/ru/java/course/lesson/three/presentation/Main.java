package ru.java.course.lesson.three.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dinyat
 * 26/09/2017
 */
public class Main {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Student alex = new Student("Alex", 18, 5.0);
        Student kate = new Student("Kate", 17, 4.5);
        Student john = new Student("John", 19, 4.0);
        list.add(alex);
        list.add(kate);
        list.add(john);

        System.out.println(list);
        Collections.sort(list,
            (o1, o2) -> Double.compare(o2.getAverageScore(), o1.getAverageScore()));
        System.out.println(list);
    }
}
