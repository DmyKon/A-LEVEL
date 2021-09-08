package ua.konstantynov.hw12;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static ua.konstantynov.hw12.PhoneBook.findIndexByPhoneNumber;

public class PhoneBookTest {

    private final String[] PHONE_BOOK = new String[3];

    @Before
    public void setUp() {
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
    }

    @Test
    public void findIndexByPhoneNumberCorrectNumberTest() {
        Assert.assertEquals(Optional.of(0), findIndexByPhoneNumber(PHONE_BOOK, "016/161616"));
        Assert.assertEquals(Optional.of(1), findIndexByPhoneNumber(PHONE_BOOK, "016/161617"));
        Assert.assertEquals(Optional.of(2), findIndexByPhoneNumber(PHONE_BOOK, "016/161618"));
    }
   @Test
    public void findIndexByPhoneNumberIncorrectNumberTest() {
        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "000/000000"));
        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "qwertyuiop"));
        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "!@#$%^&*()"));
    }

    @Test
    public void findIndexByPhoneNumberEmptyNumberTest() {
        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, ""));
    }
}