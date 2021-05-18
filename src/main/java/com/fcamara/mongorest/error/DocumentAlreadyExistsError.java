package com.fcamara.mongorest.error;

public class DocumentAlreadyExistsError {
    private String error;

    public DocumentAlreadyExistsError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
