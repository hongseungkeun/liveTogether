package com.develop.liveTogether.application.house.exception;

import com.develop.liveTogether.global.exception.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class NoAuthorizationException extends CustomException {
    public NoAuthorizationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
