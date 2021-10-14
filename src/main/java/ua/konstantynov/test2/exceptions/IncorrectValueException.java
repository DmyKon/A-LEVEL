package ua.konstantynov.test2.exceptions;

public class IncorrectValueException extends IllegalArgumentException {
    public IncorrectValueException(String message) {
        super(message);
    }
}