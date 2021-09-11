// Покрыть тестами:
// задание №2 из модуля 1 (ход коня по шахматной доске)
package ua.konstantynov.test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ua.konstantynov.test1.Test2.knightsMove;

public class Test2Test {

    @ParameterizedTest
    @CsvSource({"c1,b3", "G6,H8", "d3,e5"})
    public void testCorrectKnightsMove(String current, String target) {
        Assertions.assertTrue(knightsMove(current, target));
    }

    @ParameterizedTest
    @CsvSource({"c1,b2", "G6,a2", "e8,a1"})
    public void testIncorrectKnightsMove(String current, String target) {
        Assertions.assertFalse(knightsMove(current, target));
    }

    @ParameterizedTest
    @CsvSource({"c3,a0", "a1,b-1", "e5,f11"})
    public void testOutOfBoardKnightsMove(String current, String target) {
        Assertions.assertFalse(knightsMove(current, target));
    }

    @ParameterizedTest
    @CsvSource({"A3-B5,B5-D6", "12345,abcde", "!!!#%&^*(,98631143"})
    public void testIncorrectInputKnightsMove(String current, String target) {
        Assertions.assertFalse(knightsMove(current, target));
    }

    @ParameterizedTest
    @CsvSource({"NaN,b5", "a1,NaN", "NaN,NaN"})
    public void testEmptyInputKnightsMove(String current, String target) {
        Assertions.assertFalse(knightsMove(current, target));
    }
}