package ru.java.course.lesson.two.presentation;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Presentation {

    public static void main(String[] args)  {
        Circle circle = new Circle();
        circle.setRadius(0);
    }

    private static void doSmthDangerous() {
        throw new IllegalArgumentException();
    }

}
