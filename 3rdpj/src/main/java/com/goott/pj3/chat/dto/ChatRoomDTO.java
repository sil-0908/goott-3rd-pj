package com.goott.pj3.chat.dto;

import org.springframework.web.socket.WebSocketSession;

import java.util.*;

//2023.04.28 길영준
public class ChatRoomDTO {
    private String send_id,receive_id,read_yn, msg_content;
    private int msg_idx;
    private Date create_date;
    private List<String> checkReadOrNot;


//    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    public String getRead_yn() {
        return read_yn;
    }

    public void setRead_yn(String read_yn) {
        this.read_yn = read_yn;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
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

    public int getMsg_idx() {
        return msg_idx;
    }

    public void setMsg_idx(int msg_idx) {
        this.msg_idx = msg_idx;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public List<String> getCheckReadOrNot() {
        return checkReadOrNot;
    }

    public void setCheckReadOrNot(List<String> checkReadOrNot) {
        this.checkReadOrNot = checkReadOrNot;
    }

    @Override
    public String toString() {
        return "ChatRoomDTO{" +
                "send_id='" + send_id + '\'' +
                ", receive_id='" + receive_id + '\'' +
                ", read_yn='" + read_yn + '\'' +
                ", msg_content='" + msg_content + '\'' +
                ", msg_idx=" + msg_idx +
                ", create_date=" + create_date +
                '}';
    }
}
