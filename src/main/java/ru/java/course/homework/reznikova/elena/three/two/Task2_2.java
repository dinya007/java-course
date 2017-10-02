package ru.java.course.homework.reznikova.elena.three.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массив:");
        ArrayList<Integer> array = FillArray();
        System.out.println("Вы ввели:");
        System.out.println(array);

        HashMap<Integer, ArrayList<Pair>> pairsBySum = Preprocess(array);

        System.out.println("Введите число");
        int number = NumberInput("число");

        System.out.println(pairsBySum.get(number));

    }

    public static int NumberInput (String message)
    {
        Scanner scanner=new Scanner(System.in);
        int number=0;
        while(true)
        {
            try {
                number = Integer.parseInt(scanner.next());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Это не число! Введите "+ message + " повторно:");
            }
        }
        return number;
    }

    public static ArrayList<Integer> FillArray()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        while(true)
        {
            Integer n = NumberInput("элемент массива");
            if(array.contains(n))
            {
                System.out.println("Такое число в массиве есть, повторите ввод:");
                continue;
            }
            else
            {
                array.add(n);
                System.out.println("Добавить в массив еще число?");
                String resp = scanner.next();
                if (resp.equalsIgnoreCase("нет") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("n"))
                    break;
                System.out.println("Введите число:");
            }
        }
        return array;
    }

     public static HashMap<Integer, ArrayList<Pair>> Preprocess (ArrayList<Integer> array)
     {
         HashMap<Integer, ArrayList<Pair>> pairsBySum = new HashMap<>();
         for (int i = 0; i < array.size(); i++) {
             for (int j = i+1; j < array.size(); j++) {
                 int sum = array.get(i)+array.get(j);
                 if(pairsBySum.containsKey(sum))
                 {
                     ArrayList <Pair> p = pairsBySum.get(sum);
                     p.add(new Pair(array.get(i), array.get(j)));
                 }
                 else
                 {
                     ArrayList <Pair> p = new ArrayList<>();
                     p.add(new Pair(array.get(i), array.get(j)));
                     pairsBySum.put(array.get(i)+array.get(j), p);
                 }
             }
         }
         return pairsBySum;
     }
}
