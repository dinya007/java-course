package ru.java.course.homework.reznikova.elena.three.one;

public abstract class Unit {
    protected double power;
    protected double speed;
    private Terrian terrian;

    public Unit(double speed, double power) {
        this.speed = speed;
        this.power = power;
        this.terrian = new Road();
    }

    public void move() {
        System.out.println(this.getClass() + "is moving with speed " + speed * terrian.getSlowFactor());
    }

    public void shoot() {
    }

    public void setTerrian(Terrian terrian) {
        this.terrian = terrian;
    }

}
