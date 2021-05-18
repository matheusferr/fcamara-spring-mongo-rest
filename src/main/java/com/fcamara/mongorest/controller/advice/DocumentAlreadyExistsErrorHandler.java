package com.fcamara.mongorest.controller.advice;

import com.fcamara.mongorest.error.DocumentAlreadyExistsError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class DocumentAlreadyExistsErrorHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public DocumentAlreadyExistsError handle(ResponseStatusException e){
        return new DocumentAlreadyExistsError(e.getReason());
    }
}
