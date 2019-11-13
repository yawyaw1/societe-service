package com.societe.service.exception;

public class ValidationException extends RuntimeException {

    private String message;
    public ValidationException(){}
    public ValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
