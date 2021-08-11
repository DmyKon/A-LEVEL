package ua.konstantynov;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BubleSortArray {
    public static void main(String[] args) {
        int[] array = new int[ThreadLocalRandom.current().nextInt(5,20)];
        fillArray(array, -100, 100);
        System.out.println("Массив:                    "+Arrays.toString(array));
        System.out.println("Сортировка по возрастанию: "+Arrays.toString(sortArray(array,true)));
        System.out.println("Сортировка по убыванию:    "+Arrays.toString(sortArray(array,false)));
    }

    public static void fillArray(int[] array, int least, int bound) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(least, bound);
        }
    }

    public static int[] sortArray(int[] sortableArray, boolean ascending) {
        int[] array = Arrays.copyOf(sortableArray, sortableArray.length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if ((array[j] > array[j + 1] && ascending) ||
                        (array[j] < array[j + 1] && !ascending)) {
                    int buff = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = buff;
                }
            }
        }
        return array;
    }

}
