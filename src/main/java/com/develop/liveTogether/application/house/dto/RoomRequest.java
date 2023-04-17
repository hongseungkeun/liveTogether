package com.develop.liveTogether.application.house.dto;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PUBLIC)
public record RoomRequest(
        String roomName,
        int roomMaxPerson,
        Gender roomGender,
        int roomDeposit,
        int roomMonthly,
        int roomArea,
        String roomDate
) {

    public Room toEntity(House house, String roomImg){
        return Room.builder()
                .roomName(this.roomName)
                .roomMaxPerson(this.roomMaxPerson)
                .roomGender(this.roomGender)
                .roomDeposit(this.roomDeposit)
                .roomMonthly(this.roomMonthly)
                .roomArea(this.roomArea)
                .roomDate(this.roomDate)
                .roomImg(roomImg)
                .house(house)
                .build();
    }
}
