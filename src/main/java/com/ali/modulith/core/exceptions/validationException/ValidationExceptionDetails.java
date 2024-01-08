package com.ali.modulith.core.exceptions.validationException;

import java.util.Map;

public class ValidationExceptionDetails {
    private Map<String,String> validationErrors;
    private int code;
    private long timestamp;

    public ValidationExceptionDetails() {
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
