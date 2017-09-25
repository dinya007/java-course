package ru.java.course.homework.reznikova.elena.two.one;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("С каким видом очереди вы хотите поработать? 1 - простая, 2 - с ограничением по времени хранения");
        while (true) {
            int i = numberInput("номер очереди");
            if (i == 1) {
                FIFOQueue fifo = new FIFOQueue();
                work(fifo);
                break;
            } else if (i == 2) {
                System.out.println("Введите лимит (в минутах):");
                int limit = numberInput("лимит");
                FIFOQueue2 fifo = new FIFOQueue2(limit);
                work(fifo);
                break;
            } else {
                System.out.println("Введите 1 или 2");
            }

        }

    }

    public static void work(FIFOQueue fifo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добавить строку в очередь?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Введите строку:");
            String newElement = scanner.next();
            fifo.add(newElement);
        }
        System.out.println("Сейчас очередь выглядит так:");
        System.out.println(fifo.queue);
        while (true) {
            System.out.println("Выдать элемент?");
            String resp = scanner.next();
            if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n")) {
                break;
            }
            try {
                System.out.println(fifo.get());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static int numberInput(String message) {
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

}
