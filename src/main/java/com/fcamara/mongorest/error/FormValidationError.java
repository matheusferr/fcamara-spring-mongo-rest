package com.fcamara.mongorest.error;

public class FormValidationError {
    private String field;
    private String error;

    public FormValidationError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}