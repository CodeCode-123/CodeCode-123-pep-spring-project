package com.example.exception;

public class InvalidPostException extends RuntimeException {

    public InvalidPostException(String message) {
        super(message);
    }
}
