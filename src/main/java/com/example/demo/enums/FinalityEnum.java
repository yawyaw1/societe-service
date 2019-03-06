package com.example.demo.enums;

public enum FinalityEnum {

    ECONOMIC("economic"),
    SOCIAL("social"),
    CORPORATE("corporate");

    private String value;

    FinalityEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
