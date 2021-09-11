// Создайте класс с двумя методами f( ) и g( ). В g( ) выбросите исключение
// 1. В f( ) вызовите g( ), поймайте его исключение и, в блдоке catch, выбросите другое исключение
// 2. Проверьте ваш код в main( ).

package ua.konstantynov.hw12;

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        f();
    }

    static boolean g() throws IOException {
        throw new IOException("1 исключение g()");
    }

    static void f() {
        try {
            g();
        } catch (IOException exception) {
            throw new RuntimeException("2 исключение f()");
        }
    }
}