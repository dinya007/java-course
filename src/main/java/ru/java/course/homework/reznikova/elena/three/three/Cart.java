package ru.java.course.homework.reznikova.elena.three.three;

import java.util.HashMap;

public class Cart {
    public class CartItem {
        public Good good;
        public int quantity;
        public double totalcost;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            CartItem that = (CartItem) o;

            return good != null ? good.equals(that.good) : that.good == null;
        }

        @Override
        public int hashCode() {
            return good != null ? good.hashCode() : 0;
        }

        public CartItem() {
        }

        public CartItem(Good good, int q) {
            this.good = good;
            this.quantity = q;
            this.totalcost = good.getCost();
        }
    }

    public HashMap<Integer, CartItem> items;
    public double total;
    public int discount;

    public Cart() {
        items = new HashMap<>();
    }

    public void addGood(Good good, int quantity) {
        int id = good.getArt();
        if (items.get(id) != null) {
            items.get(id).quantity = items.get(id).quantity + quantity;
        } else {
            items.put(id, new CartItem(good, quantity));
        }
        calculateTotal();
    }

    public void calculateTotal() {
        double t = 0;
        for (CartItem v : items.values()) {
            t = t + (v.totalcost * v.quantity);
        }
        this.total = t;
    }

    public void applyDiscount(int d) {
        this.discount = d;
        for (CartItem v : items.values()) {
            v.totalcost = v.good.getCost() * (100 - d) / 100;
        }
        calculateTotal();
    }

    public void ShowCart() {
        items.forEach((k, v) -> System.out.println(v.good + ", количество: " + v.quantity));
    }
}
