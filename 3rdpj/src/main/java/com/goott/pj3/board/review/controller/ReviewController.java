package com.goott.pj3.board.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.goott.pj3.board.review.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
}
