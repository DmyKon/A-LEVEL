// 2. Проверить, заданный массив на упорядоченность по невозрастанию,
// т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
package ua.konstantynov.hw5;

public class Task2 {
    public static void main(String[] args) {
        int[] arrayTest = {16, 8, 4, 2, 1};
        System.out.println(descendingSortCheck(arrayTest));
    }

    public static boolean descendingSortCheck(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }

}