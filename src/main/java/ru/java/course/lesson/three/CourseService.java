package ru.java.course.lesson.three;

import java.util.Set;

/**
 * @author dinyat
 * 26/09/2017
 */
public interface CourseService {

    void addStudent(Student student, Set<Course> courses);

    Set<Student> getStudents(Course course);

    Set<Student> getStudents(double averageScore, int amount);

}
