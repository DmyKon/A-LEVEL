package ua.konstantynov.test2_stream_api.exceptions;

public class IncorrectValueException extends IllegalArgumentException {
    public IncorrectValueException(String message) {
        super(message);
    }
}