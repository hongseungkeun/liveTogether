package com.develop.liveTogether.application.member.data;

import lombok.Getter;

@Getter
public enum Role {
    GUEST("게스트"),
    HOST("호스트"),
    ADMIN("관리자");
    private final String role;

    Role(String role) {
        this.role = role;
    }
}
