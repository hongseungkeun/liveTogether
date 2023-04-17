package com.develop.liveTogether.application.house.dto;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PUBLIC)
public record HouseResponse(
        Long houseNumber
) {
}
