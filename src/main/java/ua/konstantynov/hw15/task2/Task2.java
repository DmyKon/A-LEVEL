//Создать класс Box содержащий параметр объем.
//● Создать отсортированный Set и поместить в него 5+ объектов Box
//● Правила сортировки:
//○ От большего к меньшему
//○ Если объем равен 0, поместить в начало списка
package ua.konstantynov.hw15.task2;

import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    public static void main(String[] args) {
        BoxComparator boxComparator = new BoxComparator();
        TreeSet<Box> treeSet = new TreeSet<>(boxComparator);
        for (int i = 0; i < 10; i++) {
            treeSet.add(new Box(ThreadLocalRandom.current().nextInt(0, 100)));
        }
        treeSet.add(new Box(0));
        System.out.println();
        for (Box box : treeSet) {
            System.out.print(box.getVolume() + " ");
        }
    }
}