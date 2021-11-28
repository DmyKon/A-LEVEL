// Покрыть тестами:
// задание №2 из ДЗ-7, метод getScholarship для Student и Aspirant
package ua.konstantynov.hw7_inheritance.task2;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetScholarshipIntegerNumbers() {
        Student student1 = new Student("", "", "", 1);
        Student student2 = new Student("", "", "", 5);
        Assert.assertEquals(80, student1.getScholarship());
        Assert.assertEquals(100, student2.getScholarship());
    }
}