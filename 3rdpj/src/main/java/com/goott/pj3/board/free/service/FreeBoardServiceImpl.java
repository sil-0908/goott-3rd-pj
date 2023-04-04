package com.goott.pj3.board.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.board.free.repo.FreeBoardDAO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	FreeBoardDAO freeBoardDAO;
	
}
