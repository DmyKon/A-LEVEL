// 3. Дан двумерный массив NxN(количество строк = количество столбцов),
// написать программу которая поменяет местами столбцы и строки.
package ua.konstantynov.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        int arrayLenght = ThreadLocalRandom.current().nextInt(2, 6);
        int[][] array = new int[arrayLenght][arrayLenght];
        fillArray(array);
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for (int[] i : swapRowAndColumn(array)) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
    }

    public static int[][] swapRowAndColumn(int[][] array) {
        int[][] swapped = new int[array.length][array[0].length];
        for (int i = 0; i < swapped.length; i++) {
            for (int j = 0; j < swapped[i].length; j++) {
                swapped[i][j] = array[j][i];
            }
        }
        return swapped;
    }

}