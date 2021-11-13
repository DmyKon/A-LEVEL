//3. Создать метод и вызвать его в main():
//метод будет сообщать, является ли целое число, переданное в метод, чётным или нет.
package ua.konstantynov.hw2_math;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        evenOrOdd(new Scanner(System.in).nextInt());
    }

    public static void evenOrOdd(int num) {
        System.out.println(num % 2 == 0 ? "Чётное" : "Нечётное");
    }
}
