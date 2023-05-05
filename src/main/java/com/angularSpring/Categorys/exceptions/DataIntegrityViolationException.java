package com.angularSpring.Categorys.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
