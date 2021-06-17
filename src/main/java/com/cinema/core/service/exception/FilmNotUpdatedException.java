package com.cinema.core.service.exception;

public class FilmNotUpdatedException extends Exception {

        public FilmNotUpdatedException() {
            super();
        }

        public FilmNotUpdatedException(String message) {
            super(message);
        }

        public FilmNotUpdatedException(String message, Throwable cause) {
            super(message, cause);
        }
}
