package com.cinema.core.service.exception;

public class FilmNotRemovedException extends Exception{

    public FilmNotRemovedException() {
        super();
    }

    public FilmNotRemovedException(String message) {
        super(message);
    }

    public FilmNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
