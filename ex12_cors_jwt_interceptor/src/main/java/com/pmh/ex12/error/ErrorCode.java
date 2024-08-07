package com.pmh.ex12.error;

public enum ErrorCode {
    NOT_FOUND("NOT_FOUND","not found with id %d"),
    BAD_REQUEST("BAD_REQUEST","Bad Request"),
    VALIDATION_ERROR("VALIDATION_ERROR","validation error %s"),
    INCORRECT_NAME_AND_EMAIL("INCORRECT_NAME_AND_EMAIL","INCORRECT_NAME_AND_EMAIL"),
    VALIDITY_PERIOD_EXPIRED("VALIDITY_PERIOD_EXPIRED","VALIDITY_PERIOD_EXPIRED"),
    INVALID_TOKEN("INVALID_TOKEN","INVALID_TOKEN"),
    NEED_TOKEN("NEED_TOKEN","NEED_TOKEN"),
    ;

    private final String code;
    private final String message;


    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage(Object... args) {
        return String.format(message,args);
    }
}
