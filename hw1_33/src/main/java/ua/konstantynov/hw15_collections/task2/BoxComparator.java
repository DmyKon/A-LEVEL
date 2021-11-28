package ua.konstantynov.hw15_collections.task2;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box box1, Box box2) {
        int value1 = box1.getVolume() == 0 ? Integer.MAX_VALUE : box1.getVolume();
        int value2 = box2.getVolume() == 0 ? Integer.MAX_VALUE : box2.getVolume();
        return Integer.compare(value2, value1);
    }
}