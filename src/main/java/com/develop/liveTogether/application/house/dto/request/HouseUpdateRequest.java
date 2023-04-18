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
        boolean opAirCon,
        boolean opCentralHeat,
        boolean opLocalHeat,
        boolean opRefrigerator,
        boolean opWasher,
        boolean opGasRange,
        boolean opInduction,
        boolean opMicrowave,
        boolean opDesk,
        boolean opDoorLock,
        boolean opBed,
        boolean opCloset,
        boolean opShoes,
        boolean opSink,
        boolean opInterPhone,
        boolean opWindow,
        boolean opCctv,
        boolean opVeranda,
        boolean opDelivery,
        boolean opFireAlarm,
        boolean houseParking,
        boolean houseElevator,
        boolean housePet,
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
                .option(Option.builder()
                        .opAirCon(this.opAirCon)
                        .opCentralHeat(this.opCentralHeat)
                        .opLocalHeat(this.opLocalHeat)
                        .opRefrigerator(this.opRefrigerator)
                        .opWasher(this.opWasher)
                        .opGasRange(this.opGasRange)
                        .opInduction(this.opInduction)
                        .opMicrowave(this.opMicrowave)
                        .opDesk(this.opDesk)
                        .opDoorLock(this.opDoorLock)
                        .opBed(this.opBed)
                        .opCloset(this.opCloset)
                        .opShoes(this.opShoes)
                        .opSink(this.opSink)
                        .opInterPhone(this.opInterPhone)
                        .opWindow(this.opWindow)
                        .opCctv(this.opCctv)
                        .opVeranda(this.opVeranda)
                        .opDelivery(this.opDelivery)
                        .opFireAlarm(this.opFireAlarm)
                        .houseParking(this.houseParking)
                        .houseElevator(this.houseElevator)
                        .housePet(this.housePet)
                        .build())
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
