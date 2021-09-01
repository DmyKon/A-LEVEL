// 1. Заполнение двумерного массива значениями индекса,
// при этом каждая вторая строка - отрицательными значениями.
package ua.konstantynov.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = new int[ThreadLocalRandom.current().nextInt(2, 11)]
                [ThreadLocalRandom.current().nextInt(2, 11)];
        fillIndexArray(array);
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void fillIndexArray(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i % 2 == 0 ? ++count : ++count * (-1);
            }
        }
    }

}