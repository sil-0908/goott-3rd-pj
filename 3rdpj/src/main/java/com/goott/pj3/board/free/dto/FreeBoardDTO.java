package com.goott.pj3.board.free.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FreeBoardDTO {

	private String user_id, free_title, free_content, free_comment, f_del_yn;
	private int free_idx;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Date create_date;
	
	public int getFree_idx() {
		return free_idx;
	}

	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFree_title() {
		return free_title;
	}

	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}

	public String getFree_content() {
		return free_content;
	}

	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}

	public String getFree_comment() {
		return free_comment;
	}

	public void setFree_comment(String free_comment) {
		this.free_comment = free_comment;
	}

	public String getF_del_yn() {
		return f_del_yn;
	}

	public void setF_del_yn(String f_del_yn) {
		this.f_del_yn = f_del_yn;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	@Override
	public String toString() {
		return "FreeDTO : [free_idx=" + free_idx + 
				", user_id=" + user_id +
				", free_title=" + free_title + 
				", free_content=" + free_content + 
				", free_comment=" + free_comment + 
				", f_del_yn=" + f_del_yn + 
				", create_date=" + create_date +  "]";
	}
}
