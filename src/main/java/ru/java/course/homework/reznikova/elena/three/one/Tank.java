package ru.java.course.homework.reznikova.elena.three.one;

public class Tank extends Unit {
    private int stock = 1;

    public Tank(double speed, double power) {
        super(speed, power);
    }

    @Override
    public void shoot() {
        if (stock == 0) {
            System.out.println(this.getClass() + " is recharging!");
            stock = 1;
        }
        System.out.println(this.getClass() + " is shooting with power " + power);
        --stock;
    }

}
