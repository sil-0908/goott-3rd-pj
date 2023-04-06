package com.test.test.user.service;

import com.test.test.user.dto.UserDTO;

public interface UserService {

	void signup(UserDTO dto);

	String getAuth(UserDTO dto);

	String signin(UserDTO dto);

	void toPlanner(String user_id);

}
