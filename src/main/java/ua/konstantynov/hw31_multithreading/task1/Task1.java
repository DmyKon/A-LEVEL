//1. Напишите приложение, которое создает 50 потоков один за
//одним, каждый из потоков выводит сообщение "Hello from thread
//(number of thread)", особенность заключается в том, что вывод
//должен быть строго в обратном порядке, от 49 до 0
package ua.konstantynov.hw31_multithreading.task1;

class Task1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setCount(50);
        myThread.start();
    }
}

class MyThread extends Thread {
    private int count;
    private int index;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count-- > 0) {
            MyThread myThread = new MyThread();
            myThread.setName(String.valueOf(index++));
            run();
            System.out.println("Hello from thread " + myThread.getName());
        }
    }
}