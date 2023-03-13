package com.develop.liveTogether.global.exception.error;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus httpStatus, String message) {
}
