package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.request.HouseAdminChangeStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HouseAdminService {
    private final HouseService houseService;

    public void changeStatus(Long houseNumber, HouseAdminChangeStatusRequest houseAdminChangeStatusRequest) {
        House house = houseService.findHouseById(houseNumber);
        house.changeStatus(houseAdminChangeStatusRequest.status());
    }
}
