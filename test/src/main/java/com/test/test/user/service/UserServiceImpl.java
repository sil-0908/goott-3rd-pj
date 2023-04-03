package com.test.test.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.user.dto.UserDTO;
import com.test.test.user.repo.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public void signup(UserDTO dto) {
		userDAO.signup(dto);
	}

	@Override
	public String getAuth(UserDTO dto) {
		return userDAO.getAuth(dto);
	}

	@Override
	public String signin(UserDTO dto) {
		return userDAO.signin(dto);
	}

	@Override
	public void toPlanner(String user_id) {
		userDAO.toPlanner(user_id);
	}
	
}
