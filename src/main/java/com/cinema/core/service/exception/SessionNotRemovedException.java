package com.cinema.core.service.exception;

public class SessionNotRemovedException extends Exception{
    public SessionNotRemovedException() {
        super();
    }

    public SessionNotRemovedException(String message) {
        super(message);
    }

    public SessionNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
