package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.domain.House;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface HouseCustomRepository {
    Slice<House> findByHouseApprovalAndRoomGuestApproval(Pageable pageable);
}
