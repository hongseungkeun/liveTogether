package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.Gender;
import com.develop.liveTogether.application.house.data.HouseType;
import com.develop.liveTogether.application.house.data.Option;
import com.develop.liveTogether.application.member.domain.Member;
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
	@Column(nullable = false, columnDefinition = "char", length=1)
	@ColumnDefault("'N'")
	private String houseStatus;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HouseType houseType;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Embedded
	private Address address;
	@Embedded
	private Option option;
	@Column(nullable = false)
	private String houseContent;
	@Column(nullable = false, length = 3000)
	private String houseMessage;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<HouseFile> houseFiles = new ArrayList<>();
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<RoomReview> roomReviews = new ArrayList<>();

	@Builder
	public House(Long houseNumber, int houseFixPeopleNum,
				 String houseStatus, HouseType houseType,
				 Gender gender, Address address,
				 Option option, String houseContent,
				 String houseMessage, Member member,
				 List<Room> rooms, List<HouseFile> houseFiles,
				 List<RoomReview> roomReviews) {
		this.houseNumber = houseNumber;
		this.houseFixPeopleNum = houseFixPeopleNum;
		this.houseStatus = houseStatus;
		this.houseType = houseType;
		this.gender = gender;
		this.address = address;
		this.option = option;
		this.houseContent = houseContent;
		this.houseMessage = houseMessage;
		this.member = member;
		this.rooms = rooms;
		this.houseFiles = houseFiles;
		this.roomReviews = roomReviews;
	}
}
