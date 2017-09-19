package ru.java.course.lesson.two.classes;

/**
 * @author dinyat
 * 18/09/2017
 */
public class ShapeUtils {

    private ShapeUtils() {
        System.out.println("Call shape utils constructor");
    }

    public static double sumAreas(Circle circle1, Circle circle2) {
        return circle1.getArea() + circle2.getArea();
    }

    public static double sumPerimeters(Circle circle1, Circle circle2) {
        return circle1.getPerimeter() + circle2.getPerimeter();
    }

    public static double sumAreas(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getArea() + rectangle2.getArea();
    }

    public static double sumPerimeters(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getPerimeter() + rectangle2.getPerimeter();
    }

    public static double sumAreas(AbstractShape shape1, AbstractShape shape2) {
        return shape1.getArea() + shape2.getArea();
    }

    public static double sumPerimeters(Shape shape1, Shape shape2) {
        return shape1.getPerimeter() + shape2.getPerimeter();
    }

}
