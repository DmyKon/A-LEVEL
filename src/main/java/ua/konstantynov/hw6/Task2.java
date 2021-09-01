// Найти и исправить ошибку в коде с помощью дебаггера.
// С помощью комментариев описать где была ошибка и как нашли.
package ua.konstantynov.hw6;

public class Task2 {
    // Код завершился с ошибкой: ArrayIndexOutOfBoundsException at ua.konstantynov.hw6.Task2.main(Task2.java:31)
    // В дебаггере видно, что программа на пытается обратиться к элементу массива
    // по несуществующему индексу j = 1 при длинне массива triangle[i] = 1
    // Внимательно осмотрев вложенный цикл была замечена ошибка в коде на 30 стоке и заменена переменная i на j
    public static void main(String[] args) {
        int[][] triangle = new int[5][];

        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];

        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }

        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {  // i < triangle[i].length" ---> j < triangle[i].length
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

    }
}