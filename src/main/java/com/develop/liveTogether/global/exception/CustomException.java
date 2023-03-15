package com.develop.liveTogether.global.exception;

import com.develop.liveTogether.global.exception.error.ErrorCode;

public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public CustomException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }
}
