// 2. Заполнить одномерный массив случайными целочисленными значениями.
// Проверить сколько простых чисел присутствует в массиве.
// Размер массива 1000 элементов.
// 3. Заполнить одномерный массив случайными целочисленными значениями.
// Проверить сколько составных чисел присутствует в массиве.
// Размер массива 1000 элементов.
package ua.konstantynov.hw4;

import java.util.concurrent.ThreadLocalRandom;

public class Task2_3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        fillArray(array);
        System.out.println("Простых чисел в массиве = " + primeCounter(array));
        System.out.println("Составных чисел в массиве = " + compositeCounter(array));
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    public static boolean numberIsPrime(int number) {
        boolean isPrime = number > 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number <= 1 || number % 2 == 0 || number % 3 == 0 || number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int primeCounter(int[] array) {
        int count = 0;
        for (int i : array) {
            if (numberIsPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static int compositeCounter(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i > 1 && !numberIsPrime(i)) {
                count++;
            }
        }
        return count;
    }

}