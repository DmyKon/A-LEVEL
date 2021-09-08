package ua.konstantynov.hw12;

import org.junit.Test;

import java.io.IOException;

import static ua.konstantynov.hw12.Task2.g;

public class Task2Test {

    @Test(expected = IOException.class)
    public void gTest() throws IOException {
        g();
    }
}