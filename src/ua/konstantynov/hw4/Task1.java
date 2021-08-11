// 1. Заполнить одномерный массив случайными целочисленными значениями.
// Найти среднее арифметическое и среднее геометрическое элементов массива.
// Размер массива - 400 элементов.
// P.S. значения элементов ограничить значениями 1-10 включительно.
package ua.konstantynov.hw4;

import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        fillArray(array, 1, 10);
        System.out.println("Среднее арифметическое массива = " + arithmeticMean(array));
        System.out.println("Среднее геометрическое массива = " + geometricMean(array));
    }

    public static void fillArray(int[] array, int least, int bound) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(least, bound);
        }
    }

    public static double geometricMean(int[] array) {
        double mul = 1;
        for (int i : array) {
            mul *= i;
        }
        return Math.round(1000000.0 * Math.pow(mul, 1.0 / array.length)) / 1000000.0;
    }

    public static double arithmeticMean(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return Math.round(1000000.0 * sum / array.length) / 1000000.0;
    }

}