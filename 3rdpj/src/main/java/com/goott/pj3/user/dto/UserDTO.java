package com.goott.pj3.user.dto;

public class UserDTO {
	
	String user_id, pw, birth, email, hp, auth;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}	
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
	return "UserDTO [user_id = " + user_id
			+ ", pw = " + pw
			+ ", birth = " + birth
			+ ", email = " + email
			+ ", hp = " + hp
			+ ", auth = " + auth + "]";
	}

}
