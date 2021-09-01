//Удалить из строки пробелы и определить, является ли она перевертышем
//Считать строку из консоли. Передать в метод, который удалит из нее все пробелы. После этого определить,
//является ли она палиндромом (перевертышем), т.е. одинаково пишется как с начала, так и с конца.
package ua.konstantynov.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new Scanner(System.in).nextLine()) ? "Палиндром" : "Не палиндром");
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9а-яА-ЯёЁ]", "").toLowerCase();
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}
