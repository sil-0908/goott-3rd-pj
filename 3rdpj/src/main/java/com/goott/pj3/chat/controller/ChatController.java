package com.goott.pj3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @RequestMapping("msg")
    public String socket(){
        return "chat/msg_ws";
    }

}
