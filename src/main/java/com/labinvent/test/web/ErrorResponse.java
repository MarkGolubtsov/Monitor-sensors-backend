package com.labinvent.test.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorResponse {
    private Date timestamp = new Date();
    private List<String> errors = new ArrayList<>();

    public void addError(String s) {
        errors.add(s);
    }

    public List<String> getErrors() {
        return errors;
    }

    public ErrorResponse setErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ErrorResponse setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
