// Покрыть тестами:
// задание №2 из ДЗ-7, метод getScholarship для Student и Aspirant
package ua.konstantynov.hw7.task2;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetScholarshipIntegerNumbers() {
        Student student1 = new Student("", "", "", 1);
        Student student2 = new Student("", "", "", 5);
        Student student3 = new Student("", "", "", 10);
        Student student4 = new Student("", "", "", 0);
        Student student5 = new Student("", "", "", -5);
        Assert.assertEquals(80, student1.getScholarship());
        Assert.assertEquals(100, student2.getScholarship());
        Assert.assertEquals(80, student3.getScholarship());
        Assert.assertEquals(80, student4.getScholarship());
        Assert.assertEquals(80, student5.getScholarship());
    }

    @Test
    public void testGetScholarshipRealNumbers() {
        Student student1 = new Student("", "", "", 5.000000000001);
        Student student2 = new Student("", "", "", 4.999999999999);
        Assert.assertEquals(80, student1.getScholarship());
        Assert.assertEquals(80, student2.getScholarship());
    }

}