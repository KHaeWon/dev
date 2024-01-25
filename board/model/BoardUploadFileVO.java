package com.example.hr.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BoardUploadFileVO {

	private int fileId;
	private int boardId;
	private String fileName;
	private String fileSize;
	private String fileContentType;
	private byte[] fileData; 
	
}
