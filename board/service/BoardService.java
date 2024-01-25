package com.example.hr.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.board.repository.IBoardRepository;

@Service
public class BoardService implements IBoardService{

	@Autowired
	IBoardRepository boardRepository;
	
	@Override
	public int selectMaxArticleNo() {
		return boardRepository.selectMaxArticleNo();
	}

	@Override
	public int selectMaxFileId() {
		return boardRepository.selectMaxFileId();
	}

}
