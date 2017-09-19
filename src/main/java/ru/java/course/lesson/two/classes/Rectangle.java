package ru.java.course.lesson.two.classes;

/**
 * @author dinyat
 * 18/09/2017
 */
public class Rectangle extends AbstractShape {

    public final double x;
    public final double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + y);
    }

}
