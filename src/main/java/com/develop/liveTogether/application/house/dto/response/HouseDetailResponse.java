package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.House;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseDetailResponse(
        Long houseNumber,
        int houseMax,
        Boolean approval,
        String houseType,
        String houseAddress,
        String houseAddressDetail,
        double latitude,
        double longitude,
        String houseLocation,
        String houseGender,
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
                .approval(house.getApproval())
                .houseType(house.getHouseType().getType())
                .houseAddress(house.getAddress().getHouseAddress())
                .houseAddressDetail(house.getAddress().getHouseAddressDetail())
                .latitude(house.getAddress().getLatitude())
                .longitude(house.getAddress().getLongitude())
                .houseLocation(house.getAddress().getHouseLocation())
                .houseGender(house.getHouseGender().getGender())
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
