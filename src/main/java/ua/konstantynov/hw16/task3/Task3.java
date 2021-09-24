//3. Написать итератор по массиву
package ua.konstantynov.hw16.task3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Arrays.setAll(arr, i -> i + ThreadLocalRandom.current().nextInt(100));
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(arr);
        System.out.println(Arrays.toString(arr));
        System.out.print("[" + arrayIterator.next() + ", ");
        System.out.print(arrayIterator.next() + ", ");
        arrayIterator.remove();
        while (arrayIterator.hasNext()) {
            System.out.print(arrayIterator.next() + (arrayIterator.hasNext() ? ", " : "]"));
        }
    }
}
