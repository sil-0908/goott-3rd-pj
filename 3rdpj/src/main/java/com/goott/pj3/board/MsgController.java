package com.goott.pj3.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {

    @RequestMapping("msg")
    public String socket(){
        return "board/msg_ws";
    }
}
