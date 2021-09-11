package ua.konstantynov.hw12;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class Task2Test {

    @Test
    public void gThrowsExceptionTest() {
        Assertions.assertThrows(IOException.class, Task2::g);
    }

    @Test
    public void fThrowsExceptionTest() {
        Assertions.assertThrows(RuntimeException.class, Task2::f);
    }
}