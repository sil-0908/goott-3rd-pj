package com.goott.pj3.chat.controller;

import com.goott.pj3.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    @RequestMapping("msg")
    public String socket(){
        return "chat/msg_ws";
    }

}
