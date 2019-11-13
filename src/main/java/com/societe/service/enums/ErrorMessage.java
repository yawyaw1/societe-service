package com.societe.service.enums;

public enum ErrorMessage {

    LOG001_MSG("Validation problem"),
    LOG002_MSG("Invalid input %s "),
    LOG003_MSG("Input not found");

    private String name;

    ErrorMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
