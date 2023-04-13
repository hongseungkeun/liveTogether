package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;
import com.develop.liveTogether.application.house.data.Option;
import com.develop.liveTogether.application.house.dto.HouseUpdate;
import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.domain.RoomGuest;
import com.develop.liveTogether.application.member.domain.RoomReview;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long houseNumber;
	@Column(nullable = false)
	private int houseFixPeopleNum;
	@Column(nullable = false)
	@ColumnDefault("0")
	private Boolean approval;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HouseType houseType;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender houseGender;
	@Embedded
	private Address address;
	@Embedded
	private Option option;
	@Column(nullable = false)
	private String houseContent;
	@Column(nullable = false, length = 3000)
	private String houseMessage;
	@Column(nullable = false)
	private String houseThumbnail;
	@Column(nullable = false)
	private String houseFloorPlan;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<RoomReview> roomReviews = new ArrayList<>();
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<RoomGuest> roomGuests = new ArrayList<>();

	@Builder
	public House(Long houseNumber, int houseFixPeopleNum,
				 Boolean approval, HouseType houseType,
				 Gender houseGender, Address address,
				 Option option, String houseContent,
				 String houseMessage, String houseThumbnail,
				 String houseFloorPlan, Member member,
				 List<Room> rooms, List<RoomReview> roomReviews,
				 List<RoomGuest> roomGuests) {
		this.houseNumber = houseNumber;
		this.houseFixPeopleNum = houseFixPeopleNum;
		this.approval = approval;
		this.houseType = houseType;
		this.houseGender = houseGender;
		this.address = address;
		this.option = option;
		this.houseContent = houseContent;
		this.houseMessage = houseMessage;
		this.houseThumbnail = houseThumbnail;
		this.houseFloorPlan = houseFloorPlan;
		this.member = member;
		this.rooms = rooms;
		this.roomReviews = roomReviews;
		this.roomGuests = roomGuests;
	}

	public void updateMyHouse(HouseUpdate houseUpdate){
		this.houseFixPeopleNum = houseUpdate.houseFixPeopleNum();
		this.houseGender = houseUpdate.houseGender();
		this.houseType = houseUpdate.houseType();
		this.address = houseUpdate.address();
		this.option = houseUpdate.option();
		this.houseContent = houseUpdate.houseContent();
		this.houseMessage = houseUpdate.houseMessage();
		this.houseThumbnail = houseUpdate.houseThumbnail();
		this.houseFloorPlan = houseUpdate.houseFloorPlan();
	}
}
