package com.societe.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorExceptionController {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage getException(NotFoundException e) {
        return new ErrorMessage(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    public ErrorMessage getErrorValidation(ValidationException e) {
        return new ErrorMessage(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorMessage> inputFieldException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        return fieldErrors.stream().map(fieldError -> new ErrorMessage(LocalDateTime.now(),Integer.valueOf(fieldError.getCode()), fieldError.getDefaultMessage())).collect(Collectors.toList());
    }
}
