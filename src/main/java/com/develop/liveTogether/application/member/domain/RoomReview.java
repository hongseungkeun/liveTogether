package com.develop.liveTogether.application.member.domain;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.HouseRoom;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    private House houseNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomNumber")
    private HouseRoom roomNumber;

    public RoomReview(Long roomGuestNumber, int star,
                      String review, Member member,
                      House houseNumber, HouseRoom roomNumber)
    {
        this.roomGuestNumber = roomGuestNumber;
        this.star = star;
        this.review = review;
        this.member = member;
        this.houseNumber = houseNumber;
        this.roomNumber = roomNumber;
    }
}
