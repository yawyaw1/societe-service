package com.example.demo.exception;

public class UserValidationException extends RuntimeException {

    private String message;
    public UserValidationException(){}
    public UserValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
