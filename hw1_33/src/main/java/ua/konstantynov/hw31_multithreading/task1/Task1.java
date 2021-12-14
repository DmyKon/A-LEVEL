//1. Напишите приложение, которое создает 50 потоков один за
//одним, каждый из потоков выводит сообщение "Hello from thread
//(number of thread)", особенность заключается в том, что вывод
//должен быть строго в обратном порядке, от 49 до 0
package ua.konstantynov.hw31_multithreading.task1;

class Task1 {
    public static void main(String[] args) throws InterruptedException {
        int count = 50;
        for (int i = 0; i < count; i++) {
            int treadIndex = count - i - 1;
            Thread myThread = new Thread(() -> {
                Thread.currentThread().setName(String.valueOf(treadIndex));
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            });
            myThread.start();
            myThread.join();
        }
    }
}