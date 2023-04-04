package com.goott.pj3.board.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.free.service.FreeBoardService;

@Controller
public class FreeBoardController {	
	
	@Autowired
	FreeBoardService freeBoardService;
	
}
