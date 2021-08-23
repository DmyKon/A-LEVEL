// Найти количество различных элементов массива.
// Пример: для 1 4 5 1 1 3 ответ 4.
// Создать метод, который принимает массив и возвращает количество уникальных элементов
package ua.konstantynov.test1;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        int[] array = {1,4,5,1,1,3};
        System.out.println(countUnique(array));
    }

    public static int countUnique(int[] array) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i : array) {
            hash.add(i);
        }
        return hash.size();
    }

}