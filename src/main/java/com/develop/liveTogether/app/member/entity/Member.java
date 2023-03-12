package com.develop.liveTogether.app.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long memberNumber;
	@Column(nullable = false)
	private String memberId;
	@Column(nullable = false)
	private String memberPw;
	@Column(nullable = false)
	private String memberName;
	@Column(nullable = false)
	private String memberNickname;
	@Column(nullable = false)
	private String memberPhone;
	@Column(nullable = false)
	private String memberGender;
	@Column(nullable = false)
	private String memberProfile;
	@Column(nullable = false)
	private String memberType;
	
	protected Member(){

	}

	@Builder
	public Member(Long memberNumber, String memberId,
				  String memberPw, String memberName,
				  String memberNickname, String memberPhone,
				  String memberGender, String memberProfile,
				  String memberType)
	{
		this.memberNumber = memberNumber;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.memberProfile = memberProfile;
		this.memberType = memberType;
	}
}
