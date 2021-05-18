package com.fcamara.mongorest.error;

public class InvalidBodyFormatError {
    private String error;

    public InvalidBodyFormatError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
