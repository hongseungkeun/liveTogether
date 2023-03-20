package com.develop.liveTogether.application.notice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "noticeNumber")
	private Notice notice;

	@Builder
	public NoticeFile(Long noticeFileNumber, String noticeFileName,
					  String noticeFileNameOriginal, Notice notice)
	{
		this.noticeFileNumber = noticeFileNumber;
		this.noticeFileName = noticeFileName;
		this.noticeFileNameOriginal = noticeFileNameOriginal;
		this.notice = notice;
	}
}