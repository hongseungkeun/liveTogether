package com.develop.liveTogether.application.member.data;

import lombok.Getter;

@Getter
public enum SuccessMessage {
    AVAILABLE_ID("사용 가능한 아이디 입니다."),
    AVAILABLE_NICKNAME("사용 가능한 아이디 입니다.");

    private final String message;

    SuccessMessage(String message){
        this.message = message;
    }
}
