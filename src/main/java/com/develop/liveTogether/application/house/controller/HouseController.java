package com.develop.liveTogether.application.house.controller;

import com.develop.liveTogether.application.house.dto.request.HouseRegisterRequest;
import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.service.HouseService;
import com.develop.liveTogether.global.annotation.LoginId;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/houses")
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

    @PostMapping
    public ResponseEntity<Void> registerHouse(@LoginId String memberId, @Valid @RequestPart HouseRegisterRequest request,
                                        @RequestPart List<MultipartFile> files){
        Long houseNumber = houseService.registerHouse(request, files);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(houseNumber)
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
