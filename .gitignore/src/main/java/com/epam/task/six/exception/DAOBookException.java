package com.epam.task.six.exception;

public class DAOBookException extends Exception {
    public DAOBookException() {
        super();
    }

    public DAOBookException(String message) {
        super(message);
    }

    public DAOBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOBookException(Throwable cause) {
        super(cause);
    }
}
