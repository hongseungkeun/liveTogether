package com.develop.liveTogether.application.house.exception;

import com.develop.liveTogether.global.exception.CustomException;
import com.develop.liveTogether.global.exception.error.ErrorCode;

public class FileNotExistException extends CustomException {
    public FileNotExistException(ErrorCode errorCode) {
        super(errorCode);
    }
}
