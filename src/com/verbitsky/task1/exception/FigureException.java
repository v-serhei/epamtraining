package com.verbitsky.task1.exception;

public class FigureException extends Exception {
    public FigureException() {
        super();
    }

    public FigureException(String message) {
        super(message);
    }

    public FigureException(Throwable cause) {
        super(cause);
    }

    public FigureException(String message, Throwable cause) {
        super(message, cause);
    }
}
