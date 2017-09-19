package ru.java.course.lesson.two.presentation;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Rectangle extends Shape {

    public final double a;
    public final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getArea() {
        return a * b;
    }
}
