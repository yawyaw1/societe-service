package com.societe.service.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessageException {

    private LocalDateTime date;
    private int code;
    private String message;

    public ErrorMessageException(LocalDateTime date, int code, String message) {
        this.date = date;
        this.code = code;
        this.message = message;
    }
}
