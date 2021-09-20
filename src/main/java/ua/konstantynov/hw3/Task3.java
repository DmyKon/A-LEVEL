//3. Количество слов в строке
//Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
package ua.konstantynov.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Количество слов в строке = " + wordCounter(new Scanner(System.in).nextLine()));
    }

    public static int wordCounter(String text) {
        String[] words = text.replaceAll("[^ a-zA-Zа-яА-ЯёЁ]", "").trim()
                .replaceAll(" +", " ").split(" ");
        return words[0].equals("") ? 0 : words.length;
    }
}
