package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.House;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseDetailResponse(
        Long houseNumber,
        int houseMax,
        String houseType,
        String houseAddress,
        String houseAddressDetail,
        double latitude,
        double longitude,
        String houseLocation,
        String houseGender,
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
        String houseContent,
        String houseMessage,
        String houseThumbnail,
        String houseFloorPlan,
        List<RoomResponse> rooms,
        List<RoomReviewResponse> roomReviews
) {
    public static HouseDetailResponse toDto(House house) {
        return HouseDetailResponse.builder()
                .houseNumber(house.getHouseNumber())
                .houseMax(house.getHouseFixPeopleNum())
                .houseType(house.getHouseType().getType())
                .houseAddress(house.getAddress().getHouseAddress())
                .houseAddressDetail(house.getAddress().getHouseAddressDetail())
                .latitude(house.getAddress().getLatitude())
                .longitude(house.getAddress().getLongitude())
                .houseLocation(house.getAddress().getHouseLocation())
                .houseGender(house.getHouseGender().getGender())
                .opAirCon(house.getOption().isOpAirCon())
                .opCentralHeat(house.getOption().isOpCentralHeat())
                .opLocalHeat(house.getOption().isOpLocalHeat())
                .opRefrigerator(house.getOption().isOpRefrigerator())
                .opWasher(house.getOption().isOpWasher())
                .opGasRange(house.getOption().isOpGasRange())
                .opInduction(house.getOption().isOpInduction())
                .opMicrowave(house.getOption().isOpMicrowave())
                .opDesk(house.getOption().isOpDesk())
                .opDoorLock(house.getOption().isOpDoorLock())
                .opBed(house.getOption().isOpBed())
                .opCloset(house.getOption().isOpCloset())
                .opShoes(house.getOption().isOpShoes())
                .opSink(house.getOption().isOpSink())
                .opInterPhone(house.getOption().isOpInterPhone())
                .opWindow(house.getOption().isOpWindow())
                .opCctv(house.getOption().isOpCctv())
                .opVeranda(house.getOption().isOpVeranda())
                .opDelivery(house.getOption().isOpDelivery())
                .opFireAlarm(house.getOption().isOpFireAlarm())
                .houseParking(house.getOption().isHouseParking())
                .houseElevator(house.getOption().isHouseElevator())
                .housePet(house.getOption().isHousePet())
                .houseContent(house.getHouseContent())
                .houseMessage(house.getHouseMessage())
                .houseThumbnail(house.getHouseThumbnail())
                .houseFloorPlan(house.getHouseFloorPlan())
                .rooms(house.getRooms()
                        .stream()
                        .map(RoomResponse::toDto)
                        .toList())
                .roomReviews(house.getRoomReviews()
                        .stream()
                        .map(RoomReviewResponse::toDto)
                        .toList())
                .build();
    }
}
