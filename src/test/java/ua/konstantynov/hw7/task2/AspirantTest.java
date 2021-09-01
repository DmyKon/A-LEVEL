// Покрыть тестами:
// задание №2 из ДЗ-7, метод getScholarship для Student и Aspirant
package ua.konstantynov.hw7.task2;

import org.junit.Assert;
import org.junit.Test;

public class AspirantTest {

    @Test
    public void testGetScholarshipIntegerNumbers() {
        Aspirant aspirant1 = new Aspirant("", "", "", 1);
        Aspirant aspirant2 = new Aspirant("", "", "", 5);
        Aspirant aspirant3 = new Aspirant("", "", "", 10);
        Aspirant aspirant4 = new Aspirant("", "", "", 0);
        Aspirant aspirant5 = new Aspirant("", "", "", -5);
        Assert.assertEquals(180, aspirant1.getScholarship());
        Assert.assertEquals(200, aspirant2.getScholarship());
        Assert.assertEquals(180, aspirant3.getScholarship());
        Assert.assertEquals(180, aspirant4.getScholarship());
        Assert.assertEquals(180, aspirant5.getScholarship());
    }

    @Test
    public void testGetScholarshipRealNumbers() {
        Aspirant aspirant1 = new Aspirant("", "", "", 5.000000000001);
        Aspirant aspirant2 = new Aspirant("", "", "", 4.999999999999);
        Assert.assertEquals(180, aspirant1.getScholarship());
        Assert.assertEquals(180, aspirant2.getScholarship());
    }

}