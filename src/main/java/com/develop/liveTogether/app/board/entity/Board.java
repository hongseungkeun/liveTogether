package com.develop.liveTogether.app.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Board {
	// 게시판 번호
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long boardNumber;
	//게시판 제목
	@Column(nullable = false)
	private String boardTitle;
	//게시판 내용
	@Column(nullable = false)
	private String boardContent;
	//작성일
	@Column(nullable = false)
	private String boardDate;
	
	protected Board() {

	}

	@Builder
	public Board(Long boardNumber, String boardTitle,
				 String boardContent, String boardDate)
	{
		this.boardNumber = boardNumber;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}
}
