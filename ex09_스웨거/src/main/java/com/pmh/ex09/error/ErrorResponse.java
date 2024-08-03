package com.pmh.ex09.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private ErrorCode errorCode;
    private String message;
    private LocalDateTime localDateTime;

    public ErrorResponse(ErrorCode errorCode, String message, LocalDateTime localDateTime) {
        this.errorCode = errorCode;
        this.message = message;
        this.localDateTime = localDateTime;
    }
}
