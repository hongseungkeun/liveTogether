package com.develop.liveTogether.application.house.exception;

import com.develop.liveTogether.global.exception.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class HouseNotFoundException extends CustomException {
    public HouseNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
