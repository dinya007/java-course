package ru.java.course.homework.reznikova.elena.three.one;

public class Infantry extends Unit{
    private int stock = 30;

    public Infantry (double speed, double power)
    {
        super(speed, power);
    }

    @Override
    public void shoot()
    {
        if(stock == 0)
        {
            System.out.println(this.getClass() + " is recharging!");
            stock = 30;
        }
        System.out.println(this.getClass() + " is shooting with power " + power);
        --stock;
    }
}
