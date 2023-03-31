package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.HouseFile;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record HouseFileResponse(
        String houseFileName
) {
    
    public static HouseFileResponse toDto(HouseFile houseFile){
        return HouseFileResponse.builder()
                .houseFileName(houseFile.getHouseFileName())
                .build();
    }
}
