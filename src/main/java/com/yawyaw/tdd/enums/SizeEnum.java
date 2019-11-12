package com.yawyaw.tdd.enums;

public enum SizeEnum {

    MICRO_BUSINESS("micro business"),
    VERY_SMALL_BUSINESS("very small business"),
    SMALL_BUSINESS("small business"),
    MEDIUM_BUSINESS("medium business"),
    BIG_BUSINESS("big business");


    private String value;

    private SizeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
