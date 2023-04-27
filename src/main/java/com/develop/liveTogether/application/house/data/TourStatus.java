package com.develop.liveTogether.application.house.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TourStatus {
    COMPLETE_TOUR_REQUEST("투어신청 완료"),
    WAIT_TOUR("투어 대기"),
    WAIT_MOVE_IN("입주 대기"),
    COMPLETE_MOVE_IN("입주 완료");

    private final String status;
}
