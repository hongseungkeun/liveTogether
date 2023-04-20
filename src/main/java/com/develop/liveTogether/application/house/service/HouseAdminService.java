package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HouseAdminService {
    private final HouseService houseService;

    public void acceptStatus(Long houseNumber) {
        House house = houseService.findHouseById(houseNumber);
        house.changeStatus();
    }
}
