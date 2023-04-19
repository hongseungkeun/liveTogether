package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;
import com.develop.liveTogether.application.house.data.Option;
import com.develop.liveTogether.application.house.dto.HouseUpdate;
import com.develop.liveTogether.application.house.dto.RoomRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record HouseUpdateRequest(
        @NotNull HouseType houseType,
        @NotBlank String houseAddress,
        @NotBlank String houseAddressDetail,
        @NotNull double latitude,
        @NotNull double longitude,
        @NotBlank String houseLocation,
        Option option,
        @NotBlank String houseContent,
        @NotBlank String houseMessage,
        @NotNull List<RoomUpdateRequest> rooms
) {
    public HouseUpdate toUpdate(String houseThumbnail, String houseFloorPlan) {
        return HouseUpdate.builder()
                .houseType(this.houseType)
                .houseGender(matchHouseGender())
                .houseFixPeopleNum(getHouseFixPeopleNum())
                .address(Address.builder()
                        .houseAddress(this.houseAddress)
                        .houseAddressDetail(this.houseAddressDetail)
                        .houseLocation(this.houseLocation)
                        .latitude(this.latitude)
                        .longitude(this.longitude).build())
                .option(this.option)
                .houseContent(this.houseContent)
                .houseMessage(this.houseMessage)
                .houseThumbnail(houseThumbnail)
                .houseFloorPlan(houseFloorPlan)
                .build();
    }

    public List<RoomRequest> getRooms(){
        return this.rooms().stream().map(RoomUpdateRequest::toRequest).toList();
    }

    private int getHouseFixPeopleNum() {
        return this.rooms
                .stream()
                .mapToInt(RoomUpdateRequest::roomMaxPerson)
                .sum();
    }

    private Gender matchHouseGender() {
        int distinctHouseGenderSize = this.rooms
                .stream()
                .map(RoomUpdateRequest::roomGender)
                .distinct()
                .toList()
                .size();

        return distinctHouseGenderSize == 1 ?
                this.rooms.stream().findAny().get().roomGender() : Gender.PUBLIC;
    }
}
