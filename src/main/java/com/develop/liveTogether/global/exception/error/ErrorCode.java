package com.develop.liveTogether.global.exception.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "아이디나 비밀번호를 다시 확인해주세요."),
    AUTH_FAILED(HttpStatus.UNAUTHORIZED, "로그인 후 이용해주세요."),
    FILE_NOT_EXIST(HttpStatus.BAD_REQUEST, "파일 읽기에 실패했습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "멤버를 찾을 수가 없습니다. 입력하신 정보를 다시 확인해주세요."),
    HOUSE_NOT_FOUND(HttpStatus.NOT_FOUND, "하우스를 찾을 수가 없습니다."),
    EXIST_MEMBER_ID(HttpStatus.CONFLICT, "이미 존재하는 아이디입니다."),
    EXIST_MEMBER_NICKNAME(HttpStatus.CONFLICT, "이미 존재하는 닉네임입니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
