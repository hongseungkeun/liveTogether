package com.develop.liveTogether.application.house.dto;

import com.develop.liveTogether.application.house.data.*;
import com.develop.liveTogether.application.house.domain.Room;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PUBLIC)
public record HouseUpdate(
        HouseType houseType,
        Gender houseGender,
        int houseFixPeopleNum,
        Status status,
        Address address,
        Option option,
        String houseContent,
        String houseMessage,
        String houseThumbnail,
        String houseFloorPlan,
        List<Room> rooms
) {
}
