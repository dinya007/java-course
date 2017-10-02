package ru.java.course.homework.reznikova.elena.three.one;

public class Main {
    public static void main(String[] args) {
        Tank t1 = new Tank(5, 10);
        Infantry i1 = new Infantry(2, 2);

        t1.shoot();
        t1.move();
        t1.shoot();
        for (int i = 0; i < 30; i++) {
            i1.shoot();
        }
        i1.shoot();

        Forest wood = new Forest();
        t1.setTerrian(wood);
        t1.shoot();
        t1.move();

        Swamp dirty = new Swamp();
        i1.setTerrian(dirty);
        i1.move();
        i1.shoot();

    }
}
