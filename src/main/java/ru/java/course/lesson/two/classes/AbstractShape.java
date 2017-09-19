package ru.java.course.lesson.two.classes;

/**
 * @author dinyat
 * 18/09/2017
 */
public abstract class AbstractShape implements Shape {

    static {
        System.out.println("Static initialization block: AbstractShape");
    }

    {
        System.out.println("Initialization block: AbstractShape");

    }

    public AbstractShape() {
        System.out.println("Constructor: AbstractShape");
    }

    public final void print() {
        System.out.println("Area: " + getArea() + " Perimeter: " + getPerimeter());
    }

}
