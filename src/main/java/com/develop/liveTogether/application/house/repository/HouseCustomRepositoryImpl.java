package com.develop.liveTogether.application.house.repository;

import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;
import com.develop.liveTogether.application.house.data.Status;
import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.dto.Filters;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static com.develop.liveTogether.application.house.domain.QHouse.house;
import static com.develop.liveTogether.application.house.domain.QRoom.room;
import static com.develop.liveTogether.application.member.domain.QRoomGuest.roomGuest;

@RequiredArgsConstructor
public class HouseCustomRepositoryImpl implements HouseCustomRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<House> findByHouseApprovalAndRoomGuestApproval(Pageable pageable) {
        List<House> houses = queryFactory.selectFrom(house)
                .where(house.status.eq(Status.ACCEPT))
                .leftJoin(house.roomGuests, roomGuest)
                .on(roomGuest.approval.eq(3))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return hasText(houses, pageable);
    }

    @Override
    public Slice<House> findByFilters(Filters filters, Pageable pageable) {
        List<House> houses = queryFactory.selectFrom(house)
                .where(
                        house.status.eq(Status.ACCEPT),
                        eqGender(filters.houseGender()),
                        eqHouseType(filters.houseType())
                )
                .leftJoin(house.rooms, room)
                .leftJoin(house.roomGuests, roomGuest)
                .on(roomGuest.approval.eq(3))
                .having(
                        goeMin(filters.min()),
                        loeMax(filters.max()),
                        goeRoomMaxPerson(filters.roomMaxPerson()),
                        goeRoomDate(filters.roomDate())
                )
                .groupBy(house.houseNumber)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return hasText(houses, pageable);
    }

    private BooleanExpression goeMin(Integer min){
        return ObjectUtils.isEmpty(min) ? null : room.roomMonthly.min().goe(min);
    }

    private BooleanExpression loeMax(Integer max){
        return ObjectUtils.isEmpty(max) ? null : room.roomMonthly.min().loe(max);
    }

    private BooleanExpression eqGender(Gender gender){
        return ObjectUtils.isEmpty(gender) ? null : house.houseGender.eq(gender);
    }

    private BooleanExpression eqHouseType(HouseType houseType){
        return ObjectUtils.isEmpty(houseType) ? null : house.houseType.eq(houseType);
    }

    private BooleanExpression goeRoomMaxPerson(Integer roomMaxPerson){
        return ObjectUtils.isEmpty(roomMaxPerson) ? null : room.roomMaxPerson.min().goe(roomMaxPerson);
    }

    private BooleanExpression goeRoomDate(String roomDate){
        return ObjectUtils.isEmpty(roomDate) ? null : room.roomDate.min().goe(roomDate);
    }

    private Slice<House> hasText(List<House> houses, Pageable pageable){
        boolean hasNext = false;

        if (houses.size() > pageable.getPageSize()) {
            houses.remove(pageable.getPageSize());
            hasNext = true;
        }

        return new SliceImpl<>(houses, pageable, hasNext);
    }
}
