package com.develop.liveTogether.application.member.data;

import lombok.Getter;

@Getter
public enum MemberGender {
    MAN("남자"),
    WOMAN("여자");
    private final String gender;

    MemberGender(String gender) {
        this.gender = gender;
    }
}
