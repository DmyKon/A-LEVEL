//2. Создать консольное приложение, которое выводит в консоль Ваши имя, фамилию и текущую дату/время.
package ua.konstantynov.hw1_terminal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;

public class Task2 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy kk:mm:ss");
        System.out.println("Дмитрий Константинов " + dateFormat.format(Calendar.getInstance().getTime()));
//      System.out.println("Дмитрий Константинов " + dateFormat.format(new Date()));
    }
}
