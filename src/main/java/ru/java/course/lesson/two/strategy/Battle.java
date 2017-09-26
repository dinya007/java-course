package ru.java.course.lesson.two.strategy;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Battle {

    public static void main(String[] args) {
        Unit t34 = new Tank(10, 5);
        Unit soldier = new Infantry(1, 1);

        soldier.move();
        t34.shoot();
        t34.shoot();
        soldier.shoot();
        t34.move();

        t34.setTerrain(new SwampTerrain());

        t34.move();
    }

}
