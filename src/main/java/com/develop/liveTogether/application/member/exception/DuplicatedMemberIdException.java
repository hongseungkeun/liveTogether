package com.develop.liveTogether.application.member.exception;

import com.develop.liveTogether.global.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class DuplicatedMemberIdException extends CustomException {
    public DuplicatedMemberIdException(ErrorCode errorCode) {
        super(errorCode);
    }
}
