package com.pmh.ex04.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeTest {

    @Test
    void getMessage() {
        ErrorCode ec1 = ErrorCode.USER_NOT_FOUND;
        System.out.println(ec1);
        System.out.println(ec1.getCode());
        System.out.println(ec1.getMessage(1l));

        ErrorCode ec2 = ErrorCode.BAD_REQUEST;
        System.out.println(ec2);
        System.out.println(ec2.getCode());
        System.out.println(ec2.getMessage("null입니다", 100, "asdfasdf"));
    }
}