package com.develop.liveTogether.application.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	@Id
	@Column(nullable = false)
	private String memberId;
	@Column(nullable = false)
	private String memberPw;
	@Column(nullable = false)
	private String memberName;
	@Column(unique = true, nullable = false)
	private String memberNickname;
	@Column(nullable = false)
	private String memberPhone;
	@Column(nullable = false)
	private String memberGender;
	@Column(nullable = false)
	private String memberProfile;
	@Column(nullable = false)
	private String memberRole;

	@Builder
	public Member(String memberId, String memberPw,
				  String memberName, String memberNickname,
				  String memberPhone, String memberGender,
				  String memberProfile, String memberRole)
	{
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.memberProfile = memberProfile;
		this.memberRole = memberRole;
	}
}
