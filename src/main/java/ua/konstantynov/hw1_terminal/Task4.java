//4. Создать приложение, которое ожидает на ввод в консоль число и выводит его в обратном порядке,
//например, пользователь вводит 3356, на выходе получаем 6533.
//Реализовать как минимум один способ.
package ua.konstantynov.hw1_terminal;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
/*      //////////////////////////     1     /////////////////////////////////
        int num = new Scanner(System.in).nextInt();
        boolean minus = num < 0;
        if (num == 0)
            System.out.print(0);
        else {
            while (Math.abs(num) > 0) {
                System.out.print(Math.abs(num) % 10);
                num /= 10;
            }
            System.out.print(minus ? "-" : "");
        }
        //////////////////////////     2     /////////////////////////////////
        System.out.println(new StringBuilder(new Scanner(System.in).nextLine()).reverse());
        //////////////////////////     3     /////////////////////////////////
        char[] num = new Scanner(System.in).nextLine().toCharArray();
        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
*/      //////////////////////////     4     /////////////////////////////////
        String num = new Scanner(System.in).nextLine();
        for (int i = num.length() - 1; i >= 0; i--) {
            System.out.print(num.charAt(i));
        }
    }
}
