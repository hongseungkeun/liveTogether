package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.HouseGender;
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
	private int houseMax;
	@Column(nullable = false, columnDefinition = "char", length=1)
	@ColumnDefault("'N'")
	private String houseStatus;
	@Column(nullable = false, columnDefinition = "char", length=1)
	@Enumerated(EnumType.STRING)
	private HouseType houseType;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HouseGender houseGender;
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
	@OneToMany(mappedBy = "roomNumber", cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();
	@OneToMany(mappedBy = "houseFileNumber", cascade = CascadeType.ALL)
	private List<HouseFile> houseFiles = new ArrayList<>();
	@OneToMany(mappedBy = "roomReviewNumber", cascade = CascadeType.ALL)
	private List<RoomReview> roomReviews = new ArrayList<>();

	@Builder
	public House(Long houseNumber, int houseMax,
				 String houseStatus, HouseType houseType,
				 HouseGender houseGender, Address address,
				 Option option, String houseContent,
				 String houseMessage, Member member,
				 List<Room> rooms, List<HouseFile> houseFiles,
				 List<RoomReview> roomReviews) {
		this.houseNumber = houseNumber;
		this.houseMax = houseMax;
		this.houseStatus = houseStatus;
		this.houseType = houseType;
		this.houseGender = houseGender;
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
