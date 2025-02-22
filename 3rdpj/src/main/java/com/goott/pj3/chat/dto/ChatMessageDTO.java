package com.goott.pj3.chat.dto;

import java.util.Date;

//2023.04.28 길영준
public class ChatMessageDTO {
    private String msg_idx;
    private String send_id;
    private String receive_id;
    private String msg_content;
    private String read_yn;
    private Date create_date;

    public String getMsg_idx() {
        return msg_idx;
    }

    public void setMsg_idx(String msg_idx) {
        this.msg_idx = msg_idx;
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(String receive_id) {
        this.receive_id = receive_id;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public String getRead_yn() {
        return read_yn;
    }

    public void setRead_yn(String read_yn) {
        this.read_yn = read_yn;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "ChatMessageDTO{" +
                "msg_idx='" + msg_idx + '\'' +
                ", send_id='" + send_id + '\'' +
                ", receive_id='" + receive_id + '\'' +
                ", msg_content='" + msg_content + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
