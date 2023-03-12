package com.develop.liveTogether.app.member.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class RoomGuest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long roomGuestNumber;
	private int star;
	private String review;
	private String roomName;
	private int status;
	private Long memberNumber;
	private Long houseNumber;
	
	protected RoomGuest() {

	}

	public RoomGuest(Long roomGuestNumber, int star,
					 String review, String roomName,
					 int status, Long memberNumber,
					 Long houseNumber)
	{
		this.roomGuestNumber = roomGuestNumber;
		this.star = star;
		this.review = review;
		this.memberNumber = memberNumber;
		this.houseNumber = houseNumber;
		this.roomName = roomName;
		this.status = status;
	}
}
