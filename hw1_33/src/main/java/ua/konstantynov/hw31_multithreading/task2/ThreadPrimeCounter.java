package ua.konstantynov.hw31_multithreading.task2;

import java.util.List;

class ThreadPrimeCounter extends Thread {
    private long count;
    private final List<Integer> list;

    @Override
    public void run() {
        count = list.stream()
                .filter(ThreadPrimeCounter::numberIsPrime)
                .count();
        System.out.printf("Thread %s counts %d prime numbers\n", Thread.currentThread().getName(), count);
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

    public ThreadPrimeCounter(List<Integer> list) {
        this.list = list;
    }

    public long getCount() {
        return count;
    }
}