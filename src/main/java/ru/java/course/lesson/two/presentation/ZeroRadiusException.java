package ru.java.course.lesson.two.presentation;

/**
 * @author dinyat
 * 19/09/2017
 */
public class ZeroRadiusException extends RuntimeException {

    public ZeroRadiusException() {
        super("Радиус не может быть равен 0");
    }
}
