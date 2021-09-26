//4. Задан список случайных чисел, с фомощью функции reduce найти минимальное число
package ua.konstantynov.hw17.task4;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> new Random().nextInt(200)-100)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("min value = " + list.stream().reduce(Integer.MAX_VALUE, Integer::min));
    }
}