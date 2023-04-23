package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.Filters;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface HouseCustomRepository {
    Slice<House> findByHouseApprovalAndRoomGuestApproval(Pageable pageable);
    Slice<House> findByFilters(Filters filters, Pageable pageable);
}
