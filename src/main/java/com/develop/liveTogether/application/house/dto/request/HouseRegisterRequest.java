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
        String opAirCon,
        String opCentralHeat,
        String opLocalHeat,
        String opRefrigerator,
        String opWasher,
        String opGasRange,
        String opInduction,
        String opMicrowave,
        String opDesk,
        String opDoorLock,
        String opBed,
        String opCloset,
        String opShoes,
        String opSink,
        String opInterPhone,
        String opWindow,
        String opCctv,
        String opVeranda,
        String opDelivery,
        String opFireAlarm,
        String houseParking,
        String houseElevator,
        String housePet,
        @NotBlank String houseContent,
        @NotBlank String houseMessage,
        @NotNull List<RoomRequest> rooms
) {
    public House toEntity(Member member) {
        return House.builder()
                .houseFixPeopleNum(findHouseFixPeopleNum())
                .houseType(this.houseType)
                .address(Address.builder()
                        .houseAddress(this.houseAddress)
                        .houseAddressDetail(this.houseAddressDetail)
                        .houseLocation(this.houseLocation)
                        .latitude(this.latitude)
                        .longitude(this.longitude).build())
                .gender(matchHouseGender())
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
                .member(member)
                .build();
    }

    private int findHouseFixPeopleNum() {
        return rooms.stream()
                .mapToInt(room -> room.roomMaxPerson())
                .sum();
    }

    private Gender matchHouseGender() {
        int distinctHouseGenderSize = rooms.stream()
                .map(room -> room.roomGender())
                .distinct()
                .toList()
                .size();

        return distinctHouseGenderSize == 1 ?
                rooms.stream().findAny().get().roomGender() : Gender.PUBLIC;
    }
}
