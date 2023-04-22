package com.develop.liveTogether.application.house.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    WAIT_REGISTER("등록 대기"),
    WAIT_UPDATE("수정 대기"),
    WAIT_DELETE("삭제 대기"),
    ACCEPT("승인"),
    REJECT("거부"),
    DELETE("삭제");

    private final String status;
}