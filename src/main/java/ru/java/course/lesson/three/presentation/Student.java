package ru.java.course.lesson.three.presentation;

/**
 * @author dinyat
 * 26/09/2017
 */
public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(getAge(), o.getAge());
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", averageScore=" + averageScore +
            '}';
    }
}
