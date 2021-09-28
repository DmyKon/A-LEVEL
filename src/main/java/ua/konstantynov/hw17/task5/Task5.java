//5. Спроектировать обьект Box который содержит коллекцию Item и поле size.
//   Item должен содержать поле name и cost
//   1. Создать коллекцию Box и инициализировать ее 10 коробками
//   2. Спроектировать метод, который случайным образом будет выбирать фильтр
//   по размеру допустимых коробок из промежутка min size <= лимит <= max size
//   3. Применить фильтр к коллекции коробок,
//   4. У оставшихся коробок взять колеекции Item
//   5. Отсортировать по цене
//   6. Вывести результат в консоль
package ua.konstantynov.hw17.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Box> boxList = new ArrayList<>();
        BoxService.fillListByRandom(boxList, 10);
        boxList.stream()
                .filter(BoxService::hasCorrectSize)
                .map(Box::getItem)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Item::getCost))
                .forEach(System.out::println);
    }
}