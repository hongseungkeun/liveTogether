package com.develop.liveTogether.application.member.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("게스트"),
    HOST("호스트"),
    ADMIN("관리자");

    private final String role;
}
