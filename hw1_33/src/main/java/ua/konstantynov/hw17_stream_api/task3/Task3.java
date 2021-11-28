//3. Задан список строк в формате даты YYYY/MM/DD, преобразовать строки в даты,
// проверить что присутствует хотя-бы одна дата за 2021 год.
package ua.konstantynov.hw17_stream_api.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2001/10/01", "2012/04/23", "2021/03/09", "2032/12/31", "3021/09/28");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(list.stream()
                .map(x -> LocalDate.parse(x, dateTimeFormatter))
                .anyMatch(x -> x.getYear() == 2021));
    }
}