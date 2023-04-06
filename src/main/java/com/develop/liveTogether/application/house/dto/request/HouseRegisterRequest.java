package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;
import com.develop.liveTogether.application.house.data.Option;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseRegisterRequest(
        HouseType houseType,
        @NotBlank String houseAddress,
        @NotBlank String houseAddressDetail,
        @NotNull double latitude,
        @NotNull double longitude,
        @NotBlank String houseLocation,
        Boolean opAirCon,
        Boolean opCentralHeat,
        Boolean opLocalHeat,
        Boolean opRefrigerator,
        Boolean opWasher,
        Boolean opGasRange,
        Boolean opInduction,
        Boolean opMicrowave,
        Boolean opDesk,
        Boolean opDoorLock,
        Boolean opBed,
        Boolean opCloset,
        Boolean opShoes,
        Boolean opSink,
        Boolean opInterPhone,
        Boolean opWindow,
        Boolean opCctv,
        Boolean opVeranda,
        Boolean opDelivery,
        Boolean opFireAlarm,
        Boolean houseParking,
        Boolean houseElevator,
        Boolean housePet,
        @NotBlank String houseContent,
        @NotBlank String houseMessage,
        @NotNull List<RoomRequest> rooms
) {
    public House toEntity(Member member, String houseThumbnail, String houseFloorPlan) {
        return House.builder()
                .houseFixPeopleNum(findHouseFixPeopleNum())
                .houseType(this.houseType)
                .address(Address.builder()
                        .houseAddress(this.houseAddress)
                        .houseAddressDetail(this.houseAddressDetail)
                        .houseLocation(this.houseLocation)
                        .latitude(this.latitude)
                        .longitude(this.longitude).build())
                .houseGender(matchHouseGender())
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
                .member(member)
                .build();
    }

    private int findHouseFixPeopleNum() {
        return rooms.stream()
                .mapToInt(RoomRequest::roomMaxPerson)
                .sum();
    }

    private Gender matchHouseGender() {
        int distinctHouseGenderSize = rooms.stream()
                .map(RoomRequest::roomGender)
                .distinct()
                .toList()
                .size();

        return distinctHouseGenderSize == 1 ?
                rooms.stream().findAny().get().roomGender() : Gender.PUBLIC;
    }
}
