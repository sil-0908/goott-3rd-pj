package com.goott.pj3.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goott.pj3.user.repo.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
}
