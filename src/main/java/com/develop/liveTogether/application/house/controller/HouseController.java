package com.develop.liveTogether.application.house.controller;

import com.develop.liveTogether.application.house.dto.HouseResponse;
import com.develop.liveTogether.application.house.dto.request.HouseRegisterRequest;
import com.develop.liveTogether.application.house.dto.request.HouseUpdateRequest;
import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.dto.response.HouseListResponse;
import com.develop.liveTogether.application.house.service.HouseService;
import com.develop.liveTogether.global.annotation.LoginId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/houses")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    @GetMapping("{houseNumber}")
    public ResponseEntity<HouseDetailResponse> getHouseDetail(@PathVariable Long houseNumber){
        HouseDetailResponse houseDetail = houseService.getHouseDetail(houseNumber);

        return ResponseEntity.ok(houseDetail);
    }

    @GetMapping
    public ResponseEntity<List<HouseListResponse>> getHouseList(Pageable pageable){
        List<HouseListResponse> houseList = houseService.getHouseList(pageable);

        return ResponseEntity.ok(houseList);
    }


    @PostMapping
    public ResponseEntity<HouseResponse> registerHouse(@LoginId String memberId, @Valid @RequestPart HouseRegisterRequest request,
                                        @RequestPart MultipartFile houseThumbnail, @RequestPart MultipartFile houseFloorPlan,
                                        @RequestPart List<MultipartFile> roomFiles){
        HouseResponse houseResponse = houseService.registerHouse(memberId, request, houseThumbnail, houseFloorPlan, roomFiles);

        return ResponseEntity.ok(houseResponse);
    }

    @PutMapping("/{houseNumber}")
    public ResponseEntity<HouseResponse> updateHouse(@PathVariable Long houseNumber, @Valid @RequestPart HouseUpdateRequest request,
                                                     @RequestPart MultipartFile houseThumbnail, @RequestPart MultipartFile houseFloorPlan,
                                                     @RequestPart List<MultipartFile> roomFiles){
        HouseResponse houseResponse = houseService.updateHouse(houseNumber, request, houseThumbnail, houseFloorPlan, roomFiles);

        return ResponseEntity.ok(houseResponse);
    }
}
