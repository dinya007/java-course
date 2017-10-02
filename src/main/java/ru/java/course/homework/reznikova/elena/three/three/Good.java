package ru.java.course.homework.reznikova.elena.three.three;

public class Good {
    private Integer art;
    private String name;
    private double cost;
    private int size;

    public Good(int art, String name, double cost, int size) {
        this.art = art;
        this.name = name;
        this.cost = cost;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Артикул: " + art + ", наименование: " + name + ", размер: " + size + ", стоимость: " + cost + "р.";
    }

    public Integer getArt() {
        return art;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Good good = (Good) o;

        return art != null ? art.equals(good.art) : good.art == null;
    }

    @Override
    public int hashCode() {
        return art != null ? art.hashCode() : 0;
    }
}
