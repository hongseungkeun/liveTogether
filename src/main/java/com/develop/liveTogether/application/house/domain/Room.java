package com.develop.liveTogether.application.house.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long roomNumber;
	@Column(nullable = false)
	private String roomName;
	@Column(nullable = false)
	private String roomMaxPerson;
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
	public Room(Long roomNumber, String roomName,
				String roomMaxPerson, String roomGender,
				int roomDeposit, int roomMonthly,
				String roomArea, String roomDate,
				House house)
	{
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.roomMaxPerson = roomMaxPerson;
		this.roomGender = roomGender;
		this.roomDeposit = roomDeposit;
		this.roomMonthly = roomMonthly;
		this.roomArea = roomArea;
		this.roomDate = roomDate;
		this.house = house;
	}
}
