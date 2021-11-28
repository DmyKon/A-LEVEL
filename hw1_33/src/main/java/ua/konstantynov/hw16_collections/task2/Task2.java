//2. Постройте частотный словарь слов (где ключ это слово, а значение - кол-во повторений).
// Данные нужно получить в отсортированном виде по значению.
package ua.konstantynov.hw16_collections.task2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        String text = "This is the house that Jack built.\n" +
                "This is the malt that lay in the house that Jack built.\n" +
                "This is the rat that ate the malt\n" +
                "That lay in the house that Jack built.\n" +
                "This is the cat that killed the rat\n" +
                "That ate the malt that lay in the house that Jack built.\n" +
                "This is the dog that worried the cat\n" +
                "That killed the rat that ate the malt\n" +
                "That lay in the house that Jack built.\n" +
                "This is the cow with the crumpled horn\n" +
                "That tossed the dog that worried the cat\n" +
                "That killed the rat that ate the malt\n" +
                "That lay in the house that Jack built.\n";
        System.out.println(wordList(text));
    }

    private static TreeMap<String, Integer> wordList(String text) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] textArray = text.replaceAll("[^ a-zA-Zа-яА-ЯёЁ]", " ").toLowerCase()
                .split(" +");
        for (String word : textArray) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        Comparator<String> comparator = (str1, str2) -> {
            if (hashMap.get(str1) >= hashMap.get(str2)) {
                return -1;
            } else {
                return 1;
            }
        };
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(hashMap);
        return treeMap;
    }
}