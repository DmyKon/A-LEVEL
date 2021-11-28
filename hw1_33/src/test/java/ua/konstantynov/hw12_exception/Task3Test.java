package ua.konstantynov.hw12_exception;

import org.junit.Test;

import static ua.konstantynov.hw12_exception.Task3.throwException;

public class Task3Test {

    @Test (expected = MyFirstException.class)
    public void throwExceptionZeroNumberTest() throws MyFirstException,
            MyThirdException, MySecondException {
        throwException(0);
    }

    @Test (expected = MySecondException.class)
    public void throwExceptionNaturalNumberTest() throws MyFirstException,
            MyThirdException, MySecondException {
        throwException(1);
    }

    @Test (expected = MyThirdException.class)
    public void throwExceptionNegativeNumberTest() throws MyFirstException,
            MyThirdException, MySecondException {
        throwException(-1);
    }
}