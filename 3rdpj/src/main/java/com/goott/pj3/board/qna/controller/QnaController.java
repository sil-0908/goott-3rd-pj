package com.goott.pj3.board.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.qna.service.QnaService;

@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
}