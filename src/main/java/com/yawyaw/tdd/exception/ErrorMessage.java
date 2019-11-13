package com.yawyaw.tdd.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {

    private LocalDateTime date;
    private int code;
    private String message;

    public ErrorMessage(LocalDateTime date, int code, String message) {
        this.date = date;
        this.code = code;
        this.message = message;
    }
}
