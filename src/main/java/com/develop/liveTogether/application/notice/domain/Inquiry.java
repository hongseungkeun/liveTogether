package com.develop.liveTogether.application.notice.domain;

import com.develop.liveTogether.application.house.domain.House;
import com.develop.liveTogether.application.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Inquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long inquiryNumber;
	@Column(nullable = false)
	private String inquiryContent;
	@Column(nullable = false)
	private String inquiryResponse;
	private String typeOption;
	@ColumnDefault("'N'")
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member member;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "houseNumber")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private House house;

	public Inquiry(Long inquiryNumber, String inquiryContent,
				   String inquiryResponse, String typeOption,
				   String status, Member member,
				   House house)
	{
		this.inquiryNumber = inquiryNumber;
		this.inquiryContent = inquiryContent;
		this.inquiryResponse = inquiryResponse;
		this.typeOption = typeOption;
		this.status = status;
		this.member = member;
		this.house = house;
	}
}
