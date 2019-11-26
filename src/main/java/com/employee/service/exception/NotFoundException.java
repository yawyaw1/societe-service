package com.employee.service.exception;

public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException(){}
    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
