package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoomRequest(
        @NotBlank String roomName,
        @NotNull int roomMaxPerson,
        Gender roomGender,
        @NotNull int roomDeposit,
        @NotNull int roomMonthly,
        @NotNull int roomArea,
        @NotBlank String roomDate
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
