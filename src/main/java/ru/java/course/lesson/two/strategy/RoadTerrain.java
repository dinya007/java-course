package ru.java.course.lesson.two.strategy;

/**
 * @author dinyat
 * 19/09/2017
 */
public class RoadTerrain implements Terrain {

    @Override
    public double getSlowFactor() {
        return 1;
    }

}
