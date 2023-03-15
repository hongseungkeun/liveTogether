package com.develop.liveTogether.application.board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeFile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long noticeFileNumber;
	@Column(nullable = false)
	private String noticeFileName;
	@Column(nullable = false)
	private String noticeFileNameOriginal;
	@Column(nullable = false)
	private int noticeNumber;

	@Builder
	public NoticeFile(Long noticeFileNumber, String noticeFileName,
					  String noticeFileNameOriginal, int noticeNumber)
	{
		this.noticeFileNumber = noticeFileNumber;
		this.noticeFileName = noticeFileName;
		this.noticeFileNameOriginal = noticeFileNameOriginal;
		this.noticeNumber = noticeNumber;
	}
}