package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.member.domain.Member;
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
    private Long roomReviewNumber;
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
    private Room room;

    @Builder
    public RoomReview(Long roomReviewNumber, int star,
                      String review, Member member,
                      House house, Room room)
    {
        this.roomReviewNumber = roomReviewNumber;
        this.star = star;
        this.review = review;
        this.member = member;
        this.house = house;
        this.room = room;
    }
}
