package ru.java.course.lesson.two.presentation;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Circle extends Shape {

    public static final double PI = 3.14;

    private double radius;

    public Circle() {
        radius = 5.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        if (radius == 0) {
            throw new ZeroRadiusException();
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    static double getArea(double radius) {
        return PI * radius * radius;
    }

}
