package com.societe.service.enums;

public enum LegalStatus {

    AUTO_ENTREPRENEUR("auto entrepreneur"),
    INDIVIDUAL_COMPANY("Individual company"),
    SOCIETY("Society");

    private String value;

    private LegalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
