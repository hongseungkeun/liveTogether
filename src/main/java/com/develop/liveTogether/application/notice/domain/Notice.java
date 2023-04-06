package com.develop.liveTogether.application.notice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long noticeNumber;
	@Column(nullable = false)
	private String noticeTitle;
	@Column(nullable = false)
	private String noticeContent;
	@CreatedDate
	@Column(nullable = false)
	private String noticeCreateDate;

	@OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
	private List<NoticeFile> noticeFiles = new ArrayList<>();

	@Builder
	public Notice(Long noticeNumber, String noticeTitle,
				  String noticeContent, String noticeCreateDate,
				  List<NoticeFile> noticeFiles)
	{
		this.noticeNumber = noticeNumber;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCreateDate = noticeCreateDate;
		this.noticeFiles = noticeFiles;
	}

	@PrePersist
	public void onPrePersist(){
		this.noticeCreateDate = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
