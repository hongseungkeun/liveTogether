package com.develop.liveTogether.application.house.controller;

import com.develop.liveTogether.application.house.dto.HouseResponse;
import com.develop.liveTogether.application.house.dto.request.HouseAdminChangeStatusRequest;
import com.develop.liveTogether.application.house.service.HouseAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/houses/admin")
@RequiredArgsConstructor
public class HouseAdminController {
    private final HouseAdminService houseAdminService;

    @PatchMapping("/{houseNumber}")
    public ResponseEntity<HouseResponse> changeStatus(@PathVariable Long houseNumber, @RequestBody HouseAdminChangeStatusRequest request){
        houseAdminService.changeStatus(houseNumber, request);

        return ResponseEntity.ok().build();
    }
}
