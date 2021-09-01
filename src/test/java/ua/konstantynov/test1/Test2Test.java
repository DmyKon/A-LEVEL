// Покрыть тестами:
// задание №2 из модуля 1 (ход коня по шахматной доске)
package ua.konstantynov.test1;

import org.junit.Assert;
import org.junit.Test;

import static ua.konstantynov.test1.Test2.knightsMove;

public class Test2Test {

    @Test
    public void testCorrectKnightsMove() {
        Assert.assertTrue(knightsMove("c1", "b3"));
        Assert.assertTrue(knightsMove("G6", "H8"));
        Assert.assertTrue(knightsMove("d3", "e5"));
    }

    @Test
    public void testIncorrectKnightsMove() {
        Assert.assertFalse(knightsMove("c1", "b2"));
        Assert.assertFalse(knightsMove("G6", "a2"));
        Assert.assertFalse(knightsMove("e8", "a1"));
    }

    @Test
    public void testOutOfBoardKnightsMove() {
        Assert.assertFalse(knightsMove("c3", "a0"));
        Assert.assertFalse(knightsMove("a1", "b-1"));
        Assert.assertFalse(knightsMove("e5", "f11"));
    }

    @Test
    public void testIncorrectInputKnightsMove() {
        Assert.assertTrue(knightsMove("A3-B5", "B5-D6"));
        Assert.assertFalse(knightsMove("12345", "abcde"));
        Assert.assertFalse(knightsMove("!!!#%&^*(", "98631143"));
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testEmptyInputKnightsMove() {
        Assert.assertFalse(knightsMove("", "b5"));
        Assert.assertFalse(knightsMove("a1", ""));
        Assert.assertFalse(knightsMove("", ""));
    }

}