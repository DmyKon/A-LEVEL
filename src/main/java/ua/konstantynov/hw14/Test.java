package ua.konstantynov.hw14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Util<String> util = new Util<>();
        util.printHashCode("Test");
        util.save("Value");
        System.out.println(util.get());
        Number[] arr = {1, 2, 3, 4, 0, 5, 6, 7};
        Double[] arrD = {1.0};
        Integer[] arrI = {1, 2};
        System.out.println(Arrays.toString(util.doubleValueIn(arr)));
        System.out.println(Arrays.toString(util.doubleValueIn(arrI)));
        System.out.println(Arrays.toString(util.doubleValueIn(arrD)));
        System.out.println(util.sumOfArray(Arrays.asList(arr)));
        List<Integer> list = new ArrayList<>();
        util.addNumbers(list);
        System.out.println(Arrays.toString(list.toArray()));
        util.sum(7, 7);
    }
}