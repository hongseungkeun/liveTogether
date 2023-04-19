package com.develop.liveTogether.application.house.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HouseType {
    APART("아파트"),
    VILLA("빌라"),
    DETACH("단독 주택"),
    ETC("기타");

    private final String type;
}
