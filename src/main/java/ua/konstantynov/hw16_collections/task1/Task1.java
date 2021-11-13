//1. Напишите метод, который добавляет 1000000 элементов в ArrayList и LinkedList.
// Напишите еще один метод, который выбирает из заполненного списка элемент наугад 100000 раз.
// Замерьте время, которое потрачено на это.
package ua.konstantynov.hw16_collections.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        addMillionValues(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList add time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        getRandomElement100_000Times(arrayList);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList get time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        addMillionValues(linkedList);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList add time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        getRandomElement100_000Times(linkedList);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList get time: " + (endTime - startTime) / 1000 + " sec");
    }

    private static void addMillionValues(List<Integer> list) {
        for (int i = 1; i <= 1000_000; i++) {
            list.add(ThreadLocalRandom.current().nextInt());
        }
    }

    private static void getRandomElement100_000Times(List<Integer> list) {
        for (int i = 0; i < 100_000; i++) {
            list.get(ThreadLocalRandom.current().nextInt(list.size()));
        }
    }
}