package com.fcamara.mongorest.controller.advice;

import com.fcamara.mongorest.error.InvalidBodyFormatError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidBodyFormatErrorHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public InvalidBodyFormatError handle(HttpMessageNotReadableException e) {
        return new InvalidBodyFormatError(e.getLocalizedMessage());
    }
}
