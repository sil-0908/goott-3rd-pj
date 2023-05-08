package com.goott.pj3.common.util.reply;

import java.util.Date;

public class ReplyDTO {

	private int reply_idx, free_idx, qna_idx, review_idx, plan_idx, travel_location_idx;
	private String r_writer, r_content;
	private Date create_date, update_date;
	public int getReply_idx() {
		return reply_idx;
	}
	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
	}
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public int getReview_idx() {
		return review_idx;
	}
	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}
	public int getPlan_idx() {
		return plan_idx;
	}
	public void setPlan_idx(int plan_idx) {
		this.plan_idx = plan_idx;
	}
	public int getTravel_location_idx() {
		return travel_location_idx;
	}
	public void setTravel_location_idx(int travel_location_idx) {
		this.travel_location_idx = travel_location_idx;
	}
	public String getR_writer() {
		return r_writer;
	}
	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "ReplyDTO [reply_idx=" + reply_idx + ""
				+ "free_idx=" + free_idx 
				+ ", qna_idx=" + qna_idx 
				+ ", review_idx=" + review_idx 
				+ ", plan_idx=" + plan_idx 
				+ ", travel_location_idx=" + travel_location_idx 
				+ ", r_writer=" + r_writer 
				+ ", r_content=" + r_content 
				+ ", create_date=" + create_date 
				+ ", update_date="+ update_date 
				+ "]";
	}

	
	
	
}
