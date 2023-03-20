package com.develop.liveTogether.application.house.service;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.response.HouseDetailResponse;
import com.develop.liveTogether.application.house.exception.HouseNotFoundException;
import com.develop.liveTogether.application.house.repository.HouseRepository;
import com.develop.liveTogether.application.member.service.MemberService;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class HouseService {
    private final MemberService memberService;
    private final HouseRepository houseRepository;

    public HouseService(MemberService memberService, HouseRepository houseRepository) {
        this.memberService = memberService;
        this.houseRepository = houseRepository;
    }

    public HouseDetailResponse getHouseDetail(Long houseNumber) {
        House house = findHouseById(houseNumber);

        return HouseDetailResponse.toDto(house);
    }

    private House findHouseById(Long houseNumber){
        return houseRepository.findById(houseNumber)
                .orElseThrow(() -> new HouseNotFoundException(ErrorCode.HOUSE_NOT_FOUND));
    }
}
