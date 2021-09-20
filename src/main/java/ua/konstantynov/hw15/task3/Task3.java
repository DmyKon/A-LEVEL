//Реализовать метод, принимающий список строк и возвращающий Map,
//где ключ - строка, значение - количество букв в строке
package ua.konstantynov.hw15.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        String text = "HashMap — основан на хэш-таблицах, реализует интерфейс Map (что " +
                "подразумевает хранение данных в виде пар ключ/значение). Ключи и значения " +
                "могут быть любых типов, в том числе и null. Данная реализация не дает " +
                "гарантий относительно порядка элементов с течением времени.";
        List<String> list = Arrays.asList(text.replaceAll("[^ a-zA-Zа-яА-ЯёЁ]", " ")
                .split(" +"));
        Map<String, Integer> hashMap = listToMap(list);
        System.out.println(hashMap);
    }

    static Map<String, Integer> listToMap(List<String> list) {
        if (list == null) {
            return null;
        }
        Map<String, Integer> hashMap = new HashMap<>(list.size());
        for (String string : list) {
            if (string != null) {
                hashMap.put(string, string.length());
            }
        }
        return hashMap;
    }
}