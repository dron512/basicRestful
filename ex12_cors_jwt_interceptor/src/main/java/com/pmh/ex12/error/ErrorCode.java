package com.pmh.ex12.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"not found with id %d"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"Bad Request"),
    VALIDATION_ERROR(HttpStatus.NOT_ACCEPTABLE,"validation error %s"),
    INCORRECT_NAME_AND_EMAIL(HttpStatus.NOT_ACCEPTABLE,"INCORRECT_NAME_AND_EMAIL"),
    VALIDITY_PERIOD_EXPIRED(HttpStatus.UNAUTHORIZED,"VALIDITY_PERIOD_EXPIRED"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED,"INVALID_TOKEN"),
    NEED_TOKEN(HttpStatus.UNAUTHORIZED,"NEED_TOKEN"),
    ;

    private final HttpStatus code;
    private final String message;


    ErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message,args);
    }
}
