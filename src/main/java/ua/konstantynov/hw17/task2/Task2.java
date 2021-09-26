//2. Задан список случайных чисел, отфильтровать числа >= 0 и получить обьект IntSummaryStatistics.
// Вывести на экране все его показатели
package ua.konstantynov.hw17.task2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> new Random().nextInt(198) - 99)
                .limit(100)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.stream()
                .filter(x -> x >= 0)
                .mapToInt(x -> x)
                .summaryStatistics());
    }
}