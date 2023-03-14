package com.develop.liveTogether.application.member.exception;

import com.develop.liveTogether.global.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
