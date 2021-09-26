//4. Задан список случайных чисел, с фомощью функции reduce найти минимальное число
package ua.konstantynov.hw17.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-100, 100));
        }
        System.out.println("min value = " + list.stream().reduce(Integer.MAX_VALUE, Integer::min));
    }
}