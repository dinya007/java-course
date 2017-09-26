package ru.java.course.lesson.two.strategy;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Tank extends Unit {

    private int ammunition = 1;

    public Tank(int power, int speed) {
        super(power, speed, new RoadTerrain());
    }

    @Override
    public void shoot() {
        System.out.println("Tank shooting with power: " + power);
        --ammunition;
        System.out.println("Recharging...");
        ammunition = 1;
    }

}
