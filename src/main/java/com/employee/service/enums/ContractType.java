package com.employee.service.enums;

public enum ContractType {

    CDD("0"),
    CDI("1"),
    TEMP("2");

    private String type;

    ContractType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
