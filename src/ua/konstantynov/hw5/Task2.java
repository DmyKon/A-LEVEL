// 2. Проверить, заданный массив на упорядоченность по невозрастанию,
// т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
package ua.konstantynov.hw5;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {16, 8, 4, 2, 1};
        System.out.println(descendingSortCheck(array));
    }

    public static boolean descendingSortCheck(int[] array) {
        boolean check = true;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                check = false;
                break;
            }
        }
        return check;
    }

}