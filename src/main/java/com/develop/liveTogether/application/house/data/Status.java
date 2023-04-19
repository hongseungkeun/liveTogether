package com.develop.liveTogether.application.house.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    WAIT_APPROVAL("승인 요청"),
    WAIT_UPDATE("수정 요청"),
    WAIT_DELETE("삭제 요청"),
    APPROVED("승인"),
    DELETED("삭제");

    private final String status;
}
