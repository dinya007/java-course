package ru.java.course.lesson.one;

/**
 * @author dinyat
 * 19/09/2017
 */
public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(6));
        System.out.println(isPrime(21));
        System.out.println(isPrime(29));
        System.out.println(isPrime(856));
        System.out.println(isPrime(857));
        System.out.println(isPrime(858));
        System.out.println(isPrime(859));
    }

    private static boolean isPrime(int number) {
        if (number == 1 || number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i < number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
