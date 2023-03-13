package com.develop.liveTogether.application.house.domain;

import com.develop.liveTogether.application.house.data.Address;
import com.develop.liveTogether.application.house.data.Option;
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

	@Builder
	public House(Long houseNumber, int houseMax,
				 String houseStatus, String houseType,
				 Address address, String houseGender,
				 Option option, String houseContent,
				 String houseMessage, Member member)
	{
		this.houseNumber = houseNumber;
		this.houseMax = houseMax;
		this.houseStatus = houseStatus;
		this.houseType = houseType;
		this.address = address;
		this.houseGender = houseGender;
		this.option = option;
		this.houseContent = houseContent;
		this.houseMessage = houseMessage;
		this.member = member;
	}
}
