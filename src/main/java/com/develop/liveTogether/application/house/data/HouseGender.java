package com.develop.liveTogether.application.house.data;

import lombok.Getter;

@Getter
public enum HouseGender {
    MAN("남성 전용"),
    WOMAN("여성 전용"),
    PUBLIC("남녀 공용");

    private final String gender;

    HouseGender(String gender) {
        this.gender = gender;
    }
}
