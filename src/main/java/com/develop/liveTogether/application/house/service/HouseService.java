package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.request.HouseRegisterRequest;
import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.exception.HouseNotFoundException;
import com.develop.liveTogether.application.house.repository.HouseRepository;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HouseService {
    private final HouseFileService houseFileService;
    private final RoomService roomService;
    private final HouseRepository houseRepository;

    public HouseService(HouseFileService houseFileService,
                        RoomService roomService, HouseRepository houseRepository) {
        this.houseFileService = houseFileService;
        this.roomService = roomService;
        this.houseRepository = houseRepository;
    }

    public HouseDetailResponse getHouseDetail(Long houseNumber) {
        House house = findHouseById(houseNumber);

        return HouseDetailResponse.toDto(house);
    }

    @Transactional
    public Long registerHouse(HouseRegisterRequest request, List<MultipartFile> files){
        House house = houseRepository.save(request.toEntity());

        houseFileService.saveFile(files, house);
        roomService.saveRoom(request.rooms(), house);

        return house.getHouseNumber();
    }

    private House findHouseById(Long houseNumber){
        return houseRepository.findById(houseNumber)
                .orElseThrow(() -> new HouseNotFoundException(ErrorCode.HOUSE_NOT_FOUND));
    }
}
