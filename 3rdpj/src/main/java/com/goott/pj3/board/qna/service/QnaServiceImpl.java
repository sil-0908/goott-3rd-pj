package com.goott.pj3.board.qna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.board.qna.repo.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDAO qnaDAO;
	
}
