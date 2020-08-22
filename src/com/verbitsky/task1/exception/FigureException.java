package com.verbitsky.task1.exception;

public class FigureException extends Exception {
    public FigureException() {
        this("Figure exception");
    }

    public FigureException(String message) {
        super("Figure exception: " + message);
    }

    public FigureException(String message, Throwable cause) {
        super("Figure exception: " + message, cause);
    }

    public FigureException(Throwable cause) {
        this("Figure exception: " + cause);
    }
}
