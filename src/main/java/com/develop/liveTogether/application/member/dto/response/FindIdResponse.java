package com.develop.liveTogether.application.member.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record FindIdResponse(
        String memberId
) {

    public static FindIdResponse toDto(String memberId){
        return FindIdResponse.builder()
                .memberId(memberId)
                .build();
    }
}
