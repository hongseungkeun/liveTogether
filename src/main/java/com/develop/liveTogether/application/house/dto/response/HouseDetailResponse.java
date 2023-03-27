package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.House;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseDetailResponse(
        Long houseNumber,
        int houseMax,
        String houseStatus,
        String houseType,
        String houseAddress,
        String houseAddressDetail,
        double latitude,
        double longitude,
        String houseLocation,
        String houseGender,
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
        String houseContent,
        String houseMessage,
        List<RoomResponse> rooms,
        List<RoomReviewResponse> roomReviews,
        String houseStructuralImg,
        List<HouseImgResponse> houseImg) {

    public static HouseDetailResponse toDto(House house) {
        return HouseDetailResponse.builder()
                .houseNumber(house.getHouseNumber())
                .houseMax(house.getHouseFixPeopleNum())
                .houseStatus(house.getHouseStatus())
                .houseType(house.getHouseType().getType())
                .houseAddress(house.getAddress().getHouseAddress())
                .houseAddressDetail(house.getAddress().getHouseAddressDetail())
                .latitude(house.getAddress().getLatitude())
                .longitude(house.getAddress().getLongitude())
                .houseLocation(house.getAddress().getHouseLocation())
                .houseGender(house.getGender().getGender())
                .opAirCon(house.getOption().getOpAirCon())
                .opCentralHeat(house.getOption().getOpCentralHeat())
                .opLocalHeat(house.getOption().getOpLocalHeat())
                .opRefrigerator(house.getOption().getOpRefrigerator())
                .opWasher(house.getOption().getOpWasher())
                .opGasRange(house.getOption().getOpGasRange())
                .opInduction(house.getOption().getOpInduction())
                .opMicrowave(house.getOption().getOpMicrowave())
                .opDesk(house.getOption().getOpDesk())
                .opDoorLock(house.getOption().getOpDoorLock())
                .opBed(house.getOption().getOpBed())
                .opCloset(house.getOption().getOpCloset())
                .opShoes(house.getOption().getOpShoes())
                .opSink(house.getOption().getOpSink())
                .opInterPhone(house.getOption().getOpInterPhone())
                .opWindow(house.getOption().getOpWindow())
                .opCctv(house.getOption().getOpCctv())
                .opVeranda(house.getOption().getOpVeranda())
                .opDelivery(house.getOption().getOpDelivery())
                .opFireAlarm(house.getOption().getOpFireAlarm())
                .houseParking(house.getOption().getHouseParking())
                .houseElevator(house.getOption().getHouseElevator())
                .housePet(house.getOption().getHousePet())
                .houseContent(house.getHouseContent())
                .houseMessage(house.getHouseMessage())
                .rooms(house.getRooms()
                        .stream()
                        .map(RoomResponse::toDto)
                        .toList())
                .roomReviews(house.getRoomReviews()
                        .stream()
                        .map(RoomReviewResponse::toDto)
                        .toList())
                .houseStructuralImg(house.getHouseFiles()
                        .get(0)
                        .getHouseFileName())
                .houseImg(house.getHouseFiles()
                        .stream()
                        .skip(1)
                        .map(HouseImgResponse::toDto)
                .toList())
                .build();
    }
}
