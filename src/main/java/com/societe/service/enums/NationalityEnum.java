package com.societe.service.enums;

public enum NationalityEnum {

    FOREIGNER("foreigner"),
    INTERNATIONAL("international"),
    NATIONAL("national");

    private String value;

    private NationalityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
