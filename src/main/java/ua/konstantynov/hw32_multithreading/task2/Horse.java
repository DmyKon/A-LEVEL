package ua.konstantynov.hw32_multithreading.task2;

import java.util.concurrent.ThreadLocalRandom;

class Horse extends Thread {
    private volatile int place;
    private final int number;

    @Override
    public void run() {
        Thread.currentThread().setName("Horse " + number);
        int distance = 1000;
        while (distance >= 0) {
            distance -= ThreadLocalRandom.current().nextInt(100, 201);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(400, 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        place = Task2.getAndIncrementHorsePlace();
    }

    public Horse(int number) {
        this.number = number;
    }

    public int getPlace() {
        return place;
    }
}