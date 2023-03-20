package com.develop.liveTogether.application.house.controller;

import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/house")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("{houseNumber}")
    public ResponseEntity<HouseDetailResponse> getHouseDetail(@PathVariable Long houseNumber){
        HouseDetailResponse houseDetail = houseService.getHouseDetail(houseNumber);

        return ResponseEntity.ok(houseDetail);
    }
}
