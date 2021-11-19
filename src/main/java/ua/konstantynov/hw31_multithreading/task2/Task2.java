//2. Напишите приложение, которое в 2 потока будет считать
//количество простых чисел, которые заданы в List, выводить
//результат и возвращать его в главный поток.
//Главный поток подсчитывает и выводит общее количество.
package ua.konstantynov.hw31_multithreading.task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Integer[] numbersArray = new Integer[1000_000];
        Arrays.setAll(numbersArray, i -> i + ThreadLocalRandom.current().nextInt());
        List<Integer> numbersList = Arrays.asList(numbersArray);
        AtomicLong primeCount = new AtomicLong();
        List<Integer> head = numbersList.subList(0, numbersList.size() / 2);
        List<Integer> tail = numbersList.subList(numbersList.size() / 2, numbersList.size());
        Thread thread1 = new Thread(() ->
                primeCount.addAndGet(head.stream()
                        .filter(Task2::numberIsPrime)
                        .count()));
        Thread thread2 = new Thread(() ->
                primeCount.addAndGet(tail.stream()
                        .filter(Task2::numberIsPrime)
                        .count()));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("List has " + primeCount + " prime numbers");
    }

    private static boolean numberIsPrime(int number) {
        boolean isPrime = number > 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number <= 1 || number % 2 == 0 || number % 3 == 0 || number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
