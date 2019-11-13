package com.yawyaw.tdd.exception;


public class EmployeeInvalidException extends RuntimeException {

    private String message;

    public EmployeeInvalidException(String message) {
        this.message = message;
    }

}
