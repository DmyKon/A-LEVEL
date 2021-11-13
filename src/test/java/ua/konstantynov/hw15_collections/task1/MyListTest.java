package ua.konstantynov.hw15_collections.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyListTest {

    @Test
    void add_AddTest() {
        MyList<String> myList = new MyList<>();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        Assertions.assertEquals("MyList{value=test1, test2, test3 }", myList.toString());
    }

    @Test
    void add_AddNullTest() {
        MyList<String> myList = new MyList<>();
        myList.add(null);
        Assertions.assertEquals("MyList{value= }", myList.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "some_text", "!@#$%^&", ""})
    void getFromLast_GetValueTest(String string) {
        MyList<String> myList = new MyList<>();
        myList.add(string);
        Assertions.assertEquals(string, myList.getFromLast(string));
    }
}