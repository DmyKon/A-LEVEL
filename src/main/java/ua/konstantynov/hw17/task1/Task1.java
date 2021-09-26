// 1. Задан массив строк. Используя средства StreamAPI отсортировать строки
// в лексикографическом порядке и вывести в консоль.
package ua.konstantynov.hw17.task1;

import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        String[] text = "ЭЭЭЭ АААА ГГГГ ББББ ДДДД ЮЮЮЮ ВВВВ ЯЯЯЯ".split(" ");
        Stream.of(text).sorted().forEach(System.out::println);
    }
}
