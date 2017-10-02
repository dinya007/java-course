package ru.java.course.homework.reznikova.elena.three.three;

import java.util.HashMap;

public class Market {
    public class MarketItem {
        public Good good;
        public int quantity;
        public int bookedQuantity;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            MarketItem that = (MarketItem) o;

            return good != null ? good.equals(that.good) : that.good == null;
        }

        @Override
        public int hashCode() {
            return good != null ? good.hashCode() : 0;
        }

        public MarketItem() {
        }

        public MarketItem(Good good, int q) {
            this.good = good;
            this.quantity = q;
            this.bookedQuantity = 0;
        }
    }

    public HashMap<Integer, MarketItem> goods;

    public Market() {
        goods = new HashMap<>();
    }

    public void addGood(Good good, int quantity) {
        goods.put(good.getArt(), new MarketItem(good, quantity));
    }

    public void showGoods() {
        goods.forEach((k, v) -> System.out.println(v.good + ", количество: " + (v.quantity - v.bookedQuantity)));
    }

    public boolean bookGood(int id, int quantity) {
        if ((goods.get(id) != null) && (goods.get(id).quantity - goods.get(id).bookedQuantity >= quantity)) {
            goods.get(id).bookedQuantity = goods.get(id).bookedQuantity + quantity;
            return true;
        } else {
            return false;
        }
    }
}
