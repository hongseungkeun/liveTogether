package com.develop.liveTogether.application.house.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseFile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long houseFileNumber;
	private String houseFileName;
	private String houseFileNameOriginal;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "houseNumber")
	private House house;

	@Builder
	public HouseFile(Long houseFileNumber, String houseFileName,
					 String houseFileNameOriginal, House house)
	{
		this.houseFileNumber = houseFileNumber;
		this.houseFileName = houseFileName;
		this.houseFileNameOriginal = houseFileNameOriginal;
		this.house = house;
	}
}
