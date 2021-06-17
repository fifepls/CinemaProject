package com.cinema.core.service.exception;

public class HallNotAddedException extends Exception{

    public HallNotAddedException() {
        super();
    }

    public HallNotAddedException(String message) {
        super(message);
    }

    public HallNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
