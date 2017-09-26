package ru.java.course.lesson.two.strategy;

/**
 * @author dinyat
 * 19/09/2017
 */
public class Infantry extends Unit {

    private int ammunition = 30;

    public Infantry(int power, int speed) {
        super(power, speed, new RoadTerrain());
    }

    @Override
    public void shoot() {
        --ammunition;
        if (ammunition == 0) {
            System.out.println("Recharging...");
            ammunition = 30;
        }
        System.out.println("Infantry shooting with power: " + power);
    }

}
