package com.cinema.core.service.exception;

public class HallNotRemovedException extends Exception{
    public HallNotRemovedException() {
        super();
    }

    public HallNotRemovedException(String message) {
        super(message);
    }

    public HallNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
