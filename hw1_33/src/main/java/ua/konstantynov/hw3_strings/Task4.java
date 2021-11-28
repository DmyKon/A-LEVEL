//Программа "Угадай число"
//Задача
//Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.
//
//Решение
//Описание переменных:
//
//secret – число, "загаданное" компьютером;
//guess – очередное число, вводимое пользователем.
//
//Алгоритм решения задачи:
//
//Программа генерирует псевдослучайное число, которое записывается в переменную secret.
//
//Пока число secret не совпадет с числом guess, пользователю будет предлагаться ввести очередное число.
//При этом, если guess > secret, то на экран будет выдаваться сообщение "Много". Иначе будет проверяться условие guess < secret.
//При его положительном значении появится сообщение "Мало", иначе сообщение "Угадал".
package ua.konstantynov.hw3_strings;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int bound = 50;
        guessTheNumber(bound);
    }

    public static void guessTheNumber(int bound) {
        int secret = new Random().nextInt(bound);
        System.out.println("Угадай число");
        while (true) {
            int guess = new Scanner(System.in).nextInt();
            if (guess > secret) {
                System.out.println("Много");
            } else if (guess < secret) {
                System.out.println("Мало");
            } else {
                System.out.println("Угадал");
                break;
            }
        }
    }
}