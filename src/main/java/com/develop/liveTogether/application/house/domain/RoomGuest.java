package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.member.domain.Member;
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
	private int approval;
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
	public RoomGuest(Long roomGuestNumber, int approval,
					 Member member, House house,
					 Room room)
	{
		this.roomGuestNumber = roomGuestNumber;
		this.approval = approval;
		this.member = member;
		this.house = house;
		this.room = room;
	}
}
