// Создайте три новых типа исключений. Напишите класс с методом, который выбрасывает все три исключения.
// В main( ) вызовите метод, но используйте только единственное предложение catch,
// которое будет ловить все три вида исключений.
package ua.konstantynov.hw12_exception;

import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        try {
            throwException(ThreadLocalRandom.current().nextInt(-1, 2));
        } catch (MyFirstException | MySecondException | MyThirdException exception) {
            exception.printStackTrace();
        }
    }

    static void throwException(int number) throws MyFirstException, MySecondException, MyThirdException {
        if (number == 0) {
            throw new MyFirstException("Число не должно быть равное нулю");
        }
        if (number > 0) {
            throw new MySecondException("Число не должно быть больше нуля");
        } else {
            throw new MyThirdException("Число не должно быть меньше нуля");
        }
    }
}

class MyFirstException extends Exception {
    public MyFirstException(String message) {
        super(message);
    }
}

class MySecondException extends Exception {
    public MySecondException(String message) {
        super(message);
    }
}

class MyThirdException extends Exception {
    public MyThirdException(String message) {
        super(message);
    }
}