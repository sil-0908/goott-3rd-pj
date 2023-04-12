package com.goott.pj3.chat.dto;

import com.goott.pj3.chat.service.ChatServiceImpl;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {

    private String room_idx;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public void handleAction(WebSocketSession session, ChatMessage chatMessage, ChatServiceImpl chatService){
    }




}
