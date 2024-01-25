package com.example.hr.board.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BoardVO {

	private int boardId;
	private int categoryId;
	private String writer;
	private String email;
	private String password;
	private String title;
	private String content;
	private Timestamp writeDate;
	private int masterId;
	private int replyNumber;
	private int replyStep;
	private int readCount;
	
}
