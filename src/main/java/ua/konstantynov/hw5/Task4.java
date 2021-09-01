// 4. Удаление из массива k-го элемента со сдвигом всех расположенных справа от него элементов
// на одну позицию влево.
package ua.konstantynov.hw5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[ThreadLocalRandom.current().nextInt(5, 11)];
        Arrays.setAll(array, i -> array[i] + ThreadLocalRandom.current().nextInt(0, 100));
        System.out.println(Arrays.toString(array));
        System.out.println("Удалить из массива элемент с индексом ...");
        System.out.println(Arrays.toString(deleteAtIndex(array, new Scanner(System.in).nextInt())));
    }

    public static int[] deleteAtIndex(int[] array, int index) {
        int[] resultArray = Arrays.copyOf(array, array.length - 1);
        if (index >= 0 && index <= array.length - 1) {
            System.arraycopy(array, index + 1, resultArray, index, resultArray.length - index);
        } else {
            return null;
        }
        return resultArray;
    }

}