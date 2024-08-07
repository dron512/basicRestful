package com.pmh.ex11.error;

public class BizException extends RuntimeException{
    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode,Object... args) {
        super(errorCode.getMessage(args));
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
