package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.HouseFile;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HouseImgResponse(
        String houseFileName
) {

    public static HouseImgResponse toDto(HouseFile houseFile){
        return HouseImgResponse.builder()
                .houseFileName(houseFile.getHouseFileName())
                .build();
    }
}
