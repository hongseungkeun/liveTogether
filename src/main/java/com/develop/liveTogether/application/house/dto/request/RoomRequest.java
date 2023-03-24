package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;

public record RoomRequest(
        String roomName,
        int roomMaxPerson,
        Gender roomGender,
        int roomDeposit,
        int roomMonthly,
        int roomArea,
        String roomDate
) {
    public Room toEntity(House house){
        return Room.builder()
                .roomName(this.roomName)
                .roomMaxPerson(this.roomMaxPerson)
                .roomGender(this.roomGender)
                .roomDeposit(this.roomDeposit)
                .roomMonthly(this.roomMonthly)
                .roomArea(this.roomArea)
                .roomDate(this.roomDate)
                .house(house)
                .build();
    }

}
