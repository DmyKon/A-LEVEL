package ua.konstantynov.test2.service;

public class IncorrectValueException extends IllegalArgumentException {
    public IncorrectValueException(String message) {
        super(message);
    }
}