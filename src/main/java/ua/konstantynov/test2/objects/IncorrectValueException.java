package ua.konstantynov.test2.objects;

public class IncorrectValueException extends IllegalArgumentException {
    public IncorrectValueException(String message) {
        super(message);
    }
}