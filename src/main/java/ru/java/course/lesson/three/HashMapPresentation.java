package ru.java.course.lesson.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dinyat
 * 16/08/2017
 */
public class HashMapPresentation {

    public static void main(String[] args) throws Exception {
        HashMap<String, Student> map = new HashMap<>();

        Student alex = new Student("Alex", "Smith", 17, 5.0);
        Student kate = new Student("Kate", "Williams", 16, 4.0);
        Student john = new Student("John", "Taylor", 18, 3.0);

        map.put(alex.getFirstName(), alex);
        map.put(kate.getFirstName(), kate);
        map.put(john.getFirstName(), john);

        System.out.println(map.get(kate.getFirstName()));
        System.out.println(map.get(alex.getFirstName()));
        System.out.println(map.get(john.getFirstName()));

        Map<Student, Set<Course>> studentCourses = new HashMap<>();

        HashSet<Course> courses = new HashSet<>();
        courses.add(Course.MATH);
        courses.add(Course.PHYSICS);
        studentCourses.put(alex, courses);
        studentCourses.put(kate, courses);
        System.out.println(studentCourses.get(alex));
        System.out.println(studentCourses.get(new Student("Kate", "Williams", 16, 4.0)));

        Map<Student, Set<Course>> newStudentCourses = studentCourses.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), Map.Entry::getValue));

        List<Integer> list = Arrays.asList(4, 2, 7);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        List<Student> students = new ArrayList<>();
        students.add(alex);
        students.add(kate);
        students.add(john);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }.reversed());

        System.out.println(students);
    }

}
