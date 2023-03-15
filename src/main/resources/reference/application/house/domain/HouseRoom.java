package com.develop.liveTogether.application.house.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long roomNumber;
	@Column(nullable = false)
	private String roomName;
	@Column(nullable = false)
	private String roomPersonType;
	@Column(nullable = false)
	private String roomGender;
	@Column(nullable = false)
	private int roomDeposit;
	@Column(nullable = false)
	private int roomMonthly;
	@Column(nullable = false)
	private String roomArea;
	@Column(nullable = false)
	private String roomDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "houseNumber")
	private House house;

	@Builder
	public HouseRoom(Long roomNumber, String roomName,
					 String roomPersonType, String roomGender,
					 int roomDeposit, int roomMonthly,
					 String roomArea, String roomDate,
					 House house)
	{
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.roomPersonType = roomPersonType;
		this.roomGender = roomGender;
		this.roomDeposit = roomDeposit;
		this.roomMonthly = roomMonthly;
		this.roomArea = roomArea;
		this.roomDate = roomDate;
		this.house = house;
	}
}
