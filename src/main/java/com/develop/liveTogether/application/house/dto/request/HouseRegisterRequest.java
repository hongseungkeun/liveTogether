package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.*;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.RoomRequest;
import com.develop.liveTogether.application.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseRegisterRequest (
        @NotNull HouseType houseType,
        @NotBlank String houseAddress,
        @NotBlank String houseAddressDetail,
        @NotNull double latitude,
        @NotNull double longitude,
        @NotBlank String houseLocation,
        Option option,
        @NotBlank String houseContent,
        @NotBlank String houseMessage,
        @NotNull List<RoomRegisterRequest> rooms
) {
    public House toEntity(Member member, String houseThumbnail, String houseFloorPlan) {
        return House.builder()
                .houseFixPeopleNum(getHouseFixPeopleNum())
                .status(Status.WAIT_REGISTER)
                .houseType(this.houseType)
                .address(Address.builder()
                        .houseAddress(this.houseAddress)
                        .houseAddressDetail(this.houseAddressDetail)
                        .houseLocation(this.houseLocation)
                        .latitude(this.latitude)
                        .longitude(this.longitude).build())
                .houseGender(matchHouseGender())
                .option(this.option)
                .houseContent(this.houseContent)
                .houseMessage(this.houseMessage)
                .houseThumbnail(houseThumbnail)
                .houseFloorPlan(houseFloorPlan)
                .member(member)
                .build();
    }

    public List<RoomRequest> getRooms(){
        return this.rooms().stream().map(RoomRegisterRequest::toRequest).toList();
    }

    private int getHouseFixPeopleNum() {
        return this.rooms
                .stream()
                .mapToInt(RoomRegisterRequest::roomMaxPerson)
                .sum();
    }

    private Gender matchHouseGender() {
        int distinctHouseGenderSize = this.rooms
                .stream()
                .map(RoomRegisterRequest::roomGender)
                .distinct()
                .toList()
                .size();

        return distinctHouseGenderSize == 1 ?
                this.rooms.stream().findAny().get().roomGender() : Gender.PUBLIC;
    }
}
