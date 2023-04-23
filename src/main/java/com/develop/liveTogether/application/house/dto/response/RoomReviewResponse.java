package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.RoomReview;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record RoomReviewResponse(
        String memberNickname,
        String memberGender,
        String memberProfile,
        int star,
        String review) {

    public static RoomReviewResponse toDto(RoomReview roomReview){
        return RoomReviewResponse.builder()
                .memberNickname(roomReview.getMember().getMemberNickname())
                .memberGender(roomReview.getMember().getMemberProfile())
                .star(roomReview.getStar())
                .review(roomReview.getReview())
                .build();
    }
}
