package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.dto.RoomRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record RoomUpdateRequest(
        @NotBlank String roomName,
        @NotNull int roomMaxPerson,
        @NotNull Gender roomGender,
        @NotNull int roomDeposit,
        @NotNull int roomMonthly,
        @NotNull int roomArea,
        @NotBlank String roomDate
) {

    public RoomRequest toRequest(){
        return RoomRequest.builder()
                .roomName(this.roomName)
                .roomMaxPerson(this.roomMaxPerson)
                .roomGender(this.roomGender)
                .roomDeposit(this.roomDeposit)
                .roomMonthly(this.roomMonthly)
                .roomArea(this.roomArea)
                .roomDate(this.roomDate)
                .build();
    }
}
