//4. Создать метод и вызвать его в main():
//Метод будет выводить на экран меньшее по модулю из  трёх переданных в метод вещественных чисел.
//Для вычисления модуля используйте тернарную операцию.
package ua.konstantynov.hw2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        minAbsNum(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
    }

    public static void minAbsNum(double a, double b, double c) {
        a = a < 0 ? a * (-1) : a;
        b = b < 0 ? b * (-1) : b;
        c = c < 0 ? c * (-1) : c;
        System.out.println(Math.min(Math.min(a, b), c));
    }
}
