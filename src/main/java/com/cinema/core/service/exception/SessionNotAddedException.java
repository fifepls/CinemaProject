package com.cinema.core.service.exception;

public class SessionNotAddedException extends Exception {
    public SessionNotAddedException() {
        super();
    }

    public SessionNotAddedException(String message) {
        super(message);
    }

    public SessionNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
