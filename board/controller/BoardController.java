package com.example.hr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hr.board.service.IBoardService;

@Controller
public class BoardController {

	@Autowired
	IBoardService boardService;

	
}
