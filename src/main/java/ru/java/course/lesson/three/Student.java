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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        if (!firstName.equals(student.firstName)) {
            return false;
        }
        return lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
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
