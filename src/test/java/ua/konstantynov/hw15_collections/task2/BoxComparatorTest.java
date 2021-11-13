package ua.konstantynov.hw15_collections.task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BoxComparatorTest {

    private static BoxComparator boxComparator;
    private static Box box1;
    private static Box box2;

    @BeforeAll
    static void beforeAll() {
        boxComparator = new BoxComparator();
        box1 = new Box();
        box2 = new Box();
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "0,10,10", "0,-10,-10"})
    void compare_IfSameNumbersReturnsZero(int expected, int value1, int value2) {
        box1.setVolume(value1);
        box2.setVolume(value2);
        assertEquals(expected, boxComparator.compare(box1, box2));
    }

    @ParameterizedTest
    @CsvSource({"-1,100,10", "-1,10,-10", "-1,-10,-100"})
    void compare_IfFirstGreaterThanSecondExceptZeroReturnsMinusOne(int expected, int value1, int value2) {
        box1.setVolume(value1);
        box2.setVolume(value2);
        assertEquals(expected, boxComparator.compare(box1, box2));
    }

    @ParameterizedTest
    @CsvSource({"1,10,100", "1,-10,10", "1,-100,-10"})
    void compare_IfFirstLessThanSecondExceptZeroReturnsOne(int expected, int value1, int value2) {
        box1.setVolume(value1);
        box2.setVolume(value2);
        assertEquals(expected, boxComparator.compare(box1, box2));
    }

    @ParameterizedTest
    @CsvSource({"-1,0,10", "-1,0,-10"})
    void compare_IfZeroFirstReturnsMinusOne(int expected, int value1, int value2) {
        box1.setVolume(value1);
        box2.setVolume(value2);
        assertEquals(expected, boxComparator.compare(box1, box2));
    }

    @ParameterizedTest
    @CsvSource({"1,10,0", "1,-10,0"})
    void compare_IfZeroSecondReturnsOne(int expected, int value1, int value2) {
        box1.setVolume(value1);
        box2.setVolume(value2);
        assertEquals(expected, boxComparator.compare(box1, box2));
    }

    @Test
    void compare_IfNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> boxComparator.compare(null, null));
    }
}