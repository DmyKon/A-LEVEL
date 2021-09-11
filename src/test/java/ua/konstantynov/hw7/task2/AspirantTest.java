// Покрыть тестами:
// задание №2 из ДЗ-7, метод getScholarship для Student и Aspirant
package ua.konstantynov.hw7.task2;

import org.junit.Assert;
import org.junit.Test;

public class AspirantTest {

    @Test
    public void testGetScholarshipIntegerNumbers() {
        Aspirant aspirant1 = new Aspirant("", "", "", "", 1);
        Aspirant aspirant2 = new Aspirant("", "", "", "", 5);
        Assert.assertEquals(180, aspirant1.getScholarship());
        Assert.assertEquals(200, aspirant2.getScholarship());
    }
}