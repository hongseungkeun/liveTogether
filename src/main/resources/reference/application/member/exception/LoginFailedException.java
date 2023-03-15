package com.develop.liveTogether.application.member.exception;

import com.develop.liveTogether.global.exception.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class LoginFailedException extends CustomException {
    public LoginFailedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
