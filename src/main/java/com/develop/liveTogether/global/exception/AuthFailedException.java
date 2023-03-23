package com.develop.liveTogether.global.exception;

import com.develop.liveTogether.global.exception.error.ErrorCode;

public class AuthFailedException extends CustomException {
    public AuthFailedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
