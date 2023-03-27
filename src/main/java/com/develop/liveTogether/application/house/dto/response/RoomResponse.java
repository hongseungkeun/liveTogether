package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.Room;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record RoomResponse(
        String roomName,
        int roomMaxPerson,
        String roomGender,
        int roomDeposit,
        int roomMonthly,
        int roomArea,
        String roomDate) {

    public static RoomResponse toDto(Room room){
        return RoomResponse.builder()
                .roomName(room.getRoomName())
                .roomMaxPerson(room.getRoomMaxPerson())
                .roomGender(room.getRoomGender().getGender())
                .roomDeposit(room.getRoomDeposit())
                .roomMonthly(room.getRoomMonthly())
                .roomArea(room.getRoomArea())
                .roomDate(room.getRoomDate())
                .build();
    }

}
