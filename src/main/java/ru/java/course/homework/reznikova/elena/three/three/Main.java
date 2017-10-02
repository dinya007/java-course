package ru.java.course.homework.reznikova.elena.three.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Market store = new Market();
        Scanner scanner = new Scanner(System.in);
        store.addGood(new Good(2, "Футболка", 200, 44), 20);
        store.addGood(new Good(1, "Шорты", 100, 46), 10);
        store.addGood(new Good(3, "Платье", 1000, 42), 23);

        while (true) {
            Cart cart = FillCart(store);
            System.out.println("В вашей корзине:");
            cart.ShowCart();

            int discount = GetDiscount();
            cart.applyDiscount(discount);
            System.out.println("Итого к оплате: " + cart.total + "р.");

            Pay(cart);
            printReciept(cart);

            System.out.println("Хотите совершить еще одну покупку?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }

        }


    }

    private static Cart FillCart(Market store) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        while (true) {
            System.out.println("В магазине есть:");
            store.showGoods();
            System.out.println("Добавить товар в корзину?");
            String resp2 = scanner.next();
            if (resp2.equalsIgnoreCase("нет") || resp2.equalsIgnoreCase("no") || resp2.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Введите id нужного товара:");
            int goodId = NumberInput("id товара");
            System.out.println("Введите количество:");
            int numberOfGoods = NumberInput("количество товара");
            if (store.bookGood(goodId, numberOfGoods)) {
                cart.addGood(store.goods.get(goodId).good, numberOfGoods);
                System.out.println("Товар добавлен");
            } else {
                System.out.println("Такого товара нет или его количества недостаточно");
            }
        }
        return cart;
    }

    private static int GetDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("У вас есть дисконтная карта? 0 - нет, 1 - 5%, 2 - 10%");
        int discount;
        while (true) {
            discount = NumberInput("тип карты");
            if (discount > 2) {
                System.out.println("Введите 0, 1 или 2:");
            } else {
                break;
            }
        }
        if (discount == 1) {
            discount = 5;
        } else if (discount == 2) {
            discount = 10;
        }

        return discount;
    }

    private static void Pay(Cart cart) {
        System.out.println("Выберите тип оплаты: 1 - картой, 2 - наличными");
        int payment;
        while (true) {
            payment = NumberInput("тип оплаты");
            if (payment > 2 || payment == 0) {
                System.out.println("Введите 1 или 2:");
            } else {
                break;
            }
        }
        if (payment == 1) {
            System.out.println("Введите номер карты:");
            int num = NumberInput("номер карты:");
            System.out.println("С карты №" + num + " списано " + cart.total + "р.");
        } else {
            System.out.println("Введите введите наличные:");
            double num = DoubleInput("сумму наличнах");
            while (num < cart.total) {
                System.out.println("Недостаточно, введи сумму больше " + cart.total);
                num = DoubleInput("сумму наличнах");
            }
            System.out.println("Ваша сдача: " + (num - cart.total));
        }
    }

    public static void printReciept(Cart cart) {
        System.out.println("Ваш чек:");
        for (Cart.CartItem v : cart.items.values()) {
            System.out.println(v.good + ", количество: " + v.quantity + ", скидка: " + cart.discount + "%, итого: " + (v.totalcost * v.quantity));
        }
        System.out.println("Сумма заказа: " + cart.total + "р., с учетом скидки " + cart.discount + "%");
    }

    public static int NumberInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите " + message + " повторно:");
            }
        }
        return number;
    }

    public static double DoubleInput(String message) {
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        while (true) {
            try {
                number = Double.parseDouble(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите " + message + " повторно:");
            }
        }
        return number;
    }
}
