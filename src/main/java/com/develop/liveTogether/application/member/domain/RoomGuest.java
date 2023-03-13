package com.develop.liveTogether.application.member.domain;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.house.domain.HouseRoom;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class RoomGuest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long roomGuestNumber;
	@ColumnDefault("'0'")
	private int status;
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
	public RoomGuest(Long roomGuestNumber, int status,
					 Member member, House house,
					 HouseRoom houseRoom)
	{
		this.roomGuestNumber = roomGuestNumber;
		this.status = status;
		this.member = member;
		this.house = house;
		this.houseRoom = houseRoom;
	}
}
