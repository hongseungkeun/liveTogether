package com.develop.liveTogether.application.member.exception;

import com.develop.liveTogether.global.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class DuplicatedNicknameException extends CustomException {
    public DuplicatedNicknameException(ErrorCode errorCode) {
        super(errorCode);
    }
}
