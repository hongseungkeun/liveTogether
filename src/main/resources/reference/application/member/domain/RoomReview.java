package com.develop.liveTogether.application.member.domain;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.HouseRoom;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomGuestNumber;
    @Column(nullable = false)
    private int star;
    @Column(nullable = false)
    private String review;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNumber")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "houseNumber")
    private House house;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomNumber")
    private HouseRoom houseRoom;

    @Builder
    public RoomReview(Long roomGuestNumber, int star,
                      String review, Member member,
                      House house, HouseRoom houseRoom)
    {
        this.roomGuestNumber = roomGuestNumber;
        this.star = star;
        this.review = review;
        this.member = member;
        this.house = house;
        this.houseRoom = houseRoom;
    }
}
