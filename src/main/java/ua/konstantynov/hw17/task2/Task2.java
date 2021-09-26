//2. Задан список случайных чисел, отфильтровать числа >= 0 и получить обьект IntSummaryStatistics.
// Вывести на экране все его показатели
package ua.konstantynov.hw17.task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[25];
        Arrays.setAll(numbers, i -> ThreadLocalRandom.current().nextInt(-100, 100));
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);
        System.out.println(list.stream().mapToInt(x -> x).filter(x -> x >= 0).summaryStatistics());
    }
}