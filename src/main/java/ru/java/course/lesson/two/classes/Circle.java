package ru.java.course.lesson.two.classes;

/**
 * @author dinyat
 * 18/09/2017
 */
public class Circle extends AbstractShape {

    private static final double PI = 3.14;

    public final double radius;

    static {
        System.out.println("Static initialization block: Circle");
    }

    {
        System.out.println("Initialization block: Circle");

    }

    public Circle() {
        System.out.println("Constructor: Circle");
        this.radius = 5.5;
    }

    public Circle(double radius) {
        System.out.println("Constructor: " + this.getClass());
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI + Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI + radius;
    }

    public static double getPI() {
        return PI;
    }

}
