package com.develop.liveTogether.application.house.data;

import lombok.Getter;

@Getter
public enum HouseType {
    APART("아파트"),
    VILLA("빌라"),
    DETACH("단독 주택"),
    ETC("기타");

    private final String type;

    HouseType(String type) {
        this.type = type;
    }
}
