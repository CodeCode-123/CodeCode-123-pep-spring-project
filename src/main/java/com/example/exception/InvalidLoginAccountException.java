package com.example.exception;

public class InvalidLoginAccountException extends RuntimeException {

    public InvalidLoginAccountException(String message) {
        super(message);
    }
}