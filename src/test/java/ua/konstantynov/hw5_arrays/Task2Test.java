// Покрыть тестами:
// задание №2 из ДЗ-5 (проверка сортировки)
package ua.konstantynov.hw5_arrays;

import org.junit.Assert;
import org.junit.Test;

import static ua.konstantynov.hw5_arrays.Task2.descendingSortCheck;

public class Task2Test {

    @Test
    public void testDescendingSort() {
        Assert.assertTrue(descendingSortCheck(new int[]{100, 77, 23, 1, 1, -33}));
        Assert.assertTrue(descendingSortCheck(new int[]{3, 2, 2, 2, 2, 2, 2}));
        Assert.assertTrue(descendingSortCheck(new int[]{-12, -30, -30}));
    }

    @Test
    public void testSameNumbers() {
        Assert.assertTrue(descendingSortCheck(new int[]{0, 0, 0, 0, 0}));
        Assert.assertTrue(descendingSortCheck(new int[]{2, 2, 2, 2}));
        Assert.assertTrue(descendingSortCheck(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void testOneNumber() {
        Assert.assertTrue(descendingSortCheck(new int[]{12}));
        Assert.assertTrue(descendingSortCheck(new int[]{2123}));
        Assert.assertTrue(descendingSortCheck(new int[]{-34}));
    }

    @Test
    public void testNoNumbers() {
        Assert.assertTrue(descendingSortCheck(new int[]{}));
    }

    @Test
    public void testAscendingSort() {
        Assert.assertFalse(descendingSortCheck(new int[]{1, 2, 3}));
        Assert.assertFalse(descendingSortCheck(new int[]{-355, -23, 0}));
        Assert.assertFalse(descendingSortCheck(new int[]{0, 0, 1, 11, 2235}));
    }

    @Test
    public void testNoSort() {
        Assert.assertFalse(descendingSortCheck(new int[]{11, 5, 745}));
        Assert.assertFalse(descendingSortCheck(new int[]{0, -1113, 154}));
        Assert.assertFalse(descendingSortCheck(new int[]{11, 11, -131, 1236}));
    }

}