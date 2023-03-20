package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.house.data.Address;
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
	@Column(nullable = false)
	@ColumnDefault("'N'")
	private String houseStatus;
	@Column(nullable = false)
	private String houseType;
	@Column(nullable = false)
	private String houseGender;
	@Embedded
	private Address address;
	@Embedded
	private Option option;
	@Column(nullable = false)
	private String houseContent;
	@Column(nullable = false)
	private String houseMessage;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;
	@OneToMany(mappedBy = "roomNumber")
	private List<Room> rooms = new ArrayList<>();
	@OneToMany(mappedBy = "houseFileNumber")
	private List<HouseFile> houseFiles = new ArrayList<>();
	@OneToMany(mappedBy = "roomReviewNumber")
	private List<RoomReview> roomReviews = new ArrayList<>();

	@Builder
	public House(Long houseNumber, int houseMax,
				 String houseStatus, String houseType,
				 String houseGender, Address address,
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
