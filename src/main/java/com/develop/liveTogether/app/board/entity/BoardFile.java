package com.develop.liveTogether.app.board.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class BoardFile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long boardFileNumber;
	@Column(nullable = false)
	private String fileName;
	@Column(nullable = false)
	private String fileNameOriginal;
	@Column(nullable = false)
	private int boardNumber;
	
	protected BoardFile() {}

	@Builder
	public BoardFile(Long boardFileNumber, String fileName,
					 int boardNumber, String fileNameOriginal)
	{
		this.fileName = fileName;
		this.boardNumber = boardNumber;
		this.fileNameOriginal = fileNameOriginal;
	}
}