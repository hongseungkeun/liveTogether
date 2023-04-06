package com.develop.liveTogether.application.house.dto.response;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.Room;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.Comparator;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record HouseListResponse(
        Long houseNumber,
        int roomDeposit,
        int roomMonthly,
        String houseGender,
        String houseType,
        int possibleMoveInPerson,
        String houseThumbnail
) {
    public static HouseListResponse toDto(House house){
        Room roomByRoomMonthlyMin = findRoomByRoomMonthlyMin(house.getRooms());

        return HouseListResponse.builder()
                .houseNumber(house.getHouseNumber())
                .roomDeposit(roomByRoomMonthlyMin.getRoomDeposit())
                .roomMonthly(roomByRoomMonthlyMin.getRoomMonthly())
                .houseGender(house.getHouseGender().getGender())
                .houseType(house.getHouseType().getType())
                .possibleMoveInPerson(house.getHouseFixPeopleNum() - house.getRoomGuests().size())
                .houseThumbnail(house.getHouseThumbnail())
                .build();
    }

    private static Room findRoomByRoomMonthlyMin(List<Room> rooms){
        return rooms.stream()
                .min(Comparator.comparing(Room::getRoomMonthly))
                .orElseThrow();
    }
}
