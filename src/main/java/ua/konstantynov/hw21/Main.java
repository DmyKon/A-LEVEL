//@AutoCreate
//public class Box {
//   @Multiplier
//   private final String name = "hello";
//   @Multiplier
//   private final Double size = 3.0;
//   private final Integer weight = 2;
//}
//
//1 Создать аннотацию @AutoCreate
//аннотацию можно применить только к классу
//2 Создать аннотацию @Multiplier
//можно применить только к полям класса
//аннотация должна принимать значение Умножение или Сложение, выбрать что-то одно по умолчанию.
//3 Создать аннотацию @Init
//можно применить только к методу
//4 Создать сервис который будет находить все классы, аннотированные @AutoCreate, создавать их экземпляры, потом
//доставать поля аннотированные @Multiplier и в зависимости от значения производить изменение полей (где это допустимо)
//Умножение - x * 3
//Сложение - x + x
//5 Созданные классы поместить в Map где ключ это идентификатор класса, а значение - сам класс.
//6 Пройтись по коллекции и вызвать у каждого класса метод аннотированный @Init
package ua.konstantynov.hw21;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> map = AutoCreateService.search();
        map.values().forEach(object -> Arrays.stream(object.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Init.class))
                .peek(method -> method.setAccessible(true))
                .forEach(method -> {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }));
    }
}