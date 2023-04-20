package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.data.Status;
import com.develop.liveTogether.application.house.domain.House;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

import static com.develop.liveTogether.application.house.domain.QHouse.house;
import static com.develop.liveTogether.application.member.domain.QRoomGuest.roomGuest;

@RequiredArgsConstructor
public class HouseCustomRepositoryImpl implements HouseCustomRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<House> findByHouseApprovalAndRoomGuestApproval(Pageable pageable) {
        List<House> lists = queryFactory.selectFrom(house)
                .where(house.status.eq(Status.APPROVED))
                .leftJoin(house.roomGuests, roomGuest)
                .on(roomGuest.approval.eq(3))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = queryFactory.select(house.count())
                .from(house)
                .where(house.status.eq(Status.APPROVED))
                .leftJoin(house.roomGuests, roomGuest)
                .on(roomGuest.approval.eq(3))
                .fetchOne();

        return new PageImpl<>(lists, pageable, count);
    }
}
