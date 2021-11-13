// 4. Заполнить одномерный массив случайными целочисленными значениями.
// Все четные значения заменить на нули.
// Размер массива - 2000 элементов.
package ua.konstantynov.hw4_arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        fillArray(array);
        int[] arrayEvenToZero = evenToZero(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayEvenToZero));
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    public static int[] evenToZero(int[] array) {
        int[] arrayEvenToZero = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arrayEvenToZero.length; i++) {
            if (arrayEvenToZero[i] % 2 == 0) {
                arrayEvenToZero[i] = 0;
            }
        }
        return arrayEvenToZero;
    }

}