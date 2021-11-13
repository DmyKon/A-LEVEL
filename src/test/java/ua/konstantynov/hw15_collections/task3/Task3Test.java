package ua.konstantynov.hw15_collections.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static ua.konstantynov.hw15_collections.task3.Task3.listToMap;

class Task3Test {

    private static Map<String, Integer> map;

    @BeforeAll
    static void beforeAll() {
        map = new HashMap<>(4);
        map.put("", 0);
        map.put("1", 1);
        map.put("22", 2);
        map.put("333", 3);
    }

    @Test
    void listToMap_CorrectWorkTest() {
        List<String> list = Arrays.asList("", "1", "22", "333");
        assertEquals(listToMap(list), map);
    }

    @Test
    void listToMap_IncorrectWorkTest() {
        List<String> list = Arrays.asList("0", "1", "22", "333");
        assertNotEquals(listToMap(list), map);
    }

    @Test
    void listToMap_ListWithNullValueTest() {
        List<String> list = Arrays.asList("", "1", null, "22", "333");
        assertEquals(listToMap(list), map);
    }

    @Test
    void listToMap_NullListTest() {
        assertNull(listToMap(null));
    }
}