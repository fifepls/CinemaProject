package com.cinema.core.service.exception;

public class FilmNotAddedException extends Exception{

    public FilmNotAddedException() {
        super();
    }

    public FilmNotAddedException(String message) {
        super(message);
    }

    public FilmNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
