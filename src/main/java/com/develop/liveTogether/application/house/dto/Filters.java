package com.develop.liveTogether.application.house.dto;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;

public record Filters(
        Integer min,
        Integer max,
        Gender houseGender,
        HouseType houseType,
        Integer roomMaxPerson,
        String roomDate
) {
}
