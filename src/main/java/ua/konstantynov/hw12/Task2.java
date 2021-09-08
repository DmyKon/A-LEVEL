// Создайте класс с двумя методами f( ) и g( ). В g( ) выбросите исключение
// 1. В f( ) вызовите g( ), поймайте его исключение и, в блдоке catch, выбросите другое исключение
// 2. Проверьте ваш код в main( ).

package ua.konstantynov.hw12;

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        try {
            f(g());
        } catch (IOException exception) {
            try {
                throw new Exception("2 исключение f()");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static boolean g() throws IOException {
        throw new IOException("1 исключение g()");
    }

    static void f(boolean value) {
    }

}