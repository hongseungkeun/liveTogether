package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.HouseResponse;
import com.develop.liveTogether.application.house.dto.request.HouseRegisterRequest;
import com.develop.liveTogether.application.house.dto.request.HouseUpdateRequest;
import com.develop.liveTogether.application.house.dto.request.RoomRegisterRequest;
import com.develop.liveTogether.application.house.dto.request.RoomUpdateRequest;
import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.dto.response.HouseListResponse;
import com.develop.liveTogether.application.house.exception.FileNotExistException;
import com.develop.liveTogether.application.house.exception.HouseNotFoundException;
import com.develop.liveTogether.application.house.repository.HouseRepository;
import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.service.MemberService;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import com.develop.liveTogether.global.util.FileUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class HouseService {
    private final MemberService memberService;
    private final RoomService roomService;
    private final HouseRepository houseRepository;

    public HouseService(MemberService memberService, RoomService roomService,
                        HouseRepository houseRepository) {
        this.memberService = memberService;
        this.roomService = roomService;
        this.houseRepository = houseRepository;
    }

    public HouseDetailResponse getHouseDetail(Long houseNumber) {
        House house = findHouseById(houseNumber);

        return HouseDetailResponse.toDto(house);
    }

    public List<HouseListResponse> getHouseList(Pageable pageable) {
        Slice<House> houses = houseRepository.findRoomGuestStatus(pageable);

        return houses.stream()
                .map(HouseListResponse::toDto)
                .toList();
    }

    @Transactional
    public HouseResponse registerHouse(String memberId, HouseRegisterRequest request,
                MultipartFile thumbnail, MultipartFile floorPlan,
                List<MultipartFile> roomFiles){
        Member member = memberService.findMemberById(memberId);

        House house = houseRepository.save(request.toEntity(member, saveFile(thumbnail), saveFile(floorPlan)));

        roomService.saveRoom(request.rooms().stream().map(RoomRegisterRequest::toEntity).toList(), house, roomFiles);

        return HouseResponse.builder().houseNumber(house.getHouseNumber()).build();
    }

    @Transactional
    public HouseResponse updateHouse(Long houseNumber, HouseUpdateRequest request,
                            MultipartFile thumbnail, MultipartFile floorPlan,
                            List<MultipartFile> roomFiles) {
        House house = findHouseById(houseNumber);

        deleteFile(house.getHouseThumbnail());
        deleteFile(house.getHouseFloorPlan());
        roomService.deleteRooms(houseNumber);

        house.updateMyHouse(request.toUpdate(saveFile(thumbnail), saveFile(floorPlan)));

        roomService.saveRoom(request.rooms().stream().map(RoomUpdateRequest::toEntity).toList(), house, roomFiles);

        return HouseResponse.builder().houseNumber(house.getHouseNumber()).build();
    }

    private House findHouseById(Long houseNumber){
        return houseRepository.findById(houseNumber)
                .orElseThrow(() -> new HouseNotFoundException(ErrorCode.HOUSE_NOT_FOUND));
    }

    private String saveFile(MultipartFile file) {
        if(file.isEmpty()) {
            throw new FileNotExistException(ErrorCode.FILE_NOT_EXIST);
        }
        String houseFileNameOriginal = file.getOriginalFilename();
        String houseFileName = UUID.randomUUID() + "." + FileUtil.extractExt(houseFileNameOriginal);

        Path path = Paths.get(FileUtil.getFilePath(houseFileName)).toAbsolutePath();

        try {
            file.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return houseFileName;
    }

    private void deleteFile(String houseFileName) {
        File file = new File(FileUtil.getFilePath(houseFileName));

        if(file.exists()){
            file.delete();
        }
    }
}
