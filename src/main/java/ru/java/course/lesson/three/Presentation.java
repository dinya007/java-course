package ru.java.course.lesson.three;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dinyat
 * 16/08/2017
 */
public class Presentation {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        Student alex = new Student("Alex", "Smith", 17);
        Student kate = new Student("Kate", "Williams", 16);
        Student john = new Student("John", "Taylor", 18);

        list.add(alex);
        list.add("assad");
        list.add(kate);
        list.add(john);

        Collections.sort(list);

//        System.out.println(list);
    }


}
