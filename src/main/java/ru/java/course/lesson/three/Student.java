package ru.java.course.lesson.three;

/**
 * @author dinyat
 * 16/08/2017
 */
public class Student implements Comparable {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final double averageScore;

    public Student(String firstName, String lastName, int age, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", averageScore=" + averageScore +
            '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.age, ((Student) o).age
        );
    }
}
