package ru.java.course.lesson.two.classes;

import java.util.Arrays;
import java.util.List;

/**
 * @author dinyat
 * 18/09/2017
 */
public class Classes1 {

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(20.5);

        System.out.println(circle1.radius);
        System.out.println(circle1.getArea());

        System.out.println(circle2.radius);
        System.out.println(circle2.getArea());

        System.out.println(ShapeUtils.sumAreas(circle1, circle2));
        System.out.println(ShapeUtils.sumPerimeters(circle1, circle2));

//        new AbstractShape()

        AbstractShape rectangle = new Rectangle(3.4, 6.7);

        System.out.println(ShapeUtils.sumPerimeters(rectangle, circle1));
        rectangle.print();

        List<Shape> shapes = Arrays.asList(circle1, circle2, rectangle);

        double sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.getArea();
        }
        System.out.println(sumArea);
    }

}
