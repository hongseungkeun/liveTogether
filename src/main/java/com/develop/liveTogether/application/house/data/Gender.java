package com.develop.liveTogether.application.house.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MAN("남성 전용"),
    WOMAN("여성 전용"),
    PUBLIC("남녀 공용");

    private final String gender;
}
