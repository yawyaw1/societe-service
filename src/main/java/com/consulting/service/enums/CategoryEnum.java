package com.consulting.service.enums;

public enum CategoryEnum {

    BUSINESS("business"),
    PUBLIC_ORGANIZATION("public organization"),
    ASSOCIATION("association");


    private String value;

    CategoryEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
