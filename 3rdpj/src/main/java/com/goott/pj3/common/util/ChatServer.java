package com.goott.pj3.common.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ServerEndpoint("/chat")
public class ChatServer {
    private static List<Session> list = new ArrayList<Session>();

    private void print(String message) {
        System.out.printf("[%tT] %s\n", Calendar.getInstance(), message);
    }

    @OnOpen
    public void handleOpen(Session session) {
        print("클라이언트 연결");
        list.add(session);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        int index = message.indexOf("#", 2);
        String no = message.substring(0, 1);
        String user = message.substring(2, index);
        String txt = message.substring(index + 1);

        if (no.equals("1")) {
            for (Session s : list) {
                if (s != session) {
                    try {
                        session.getBasicRemote().sendText("1#" + user + "#");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else if(no.equals("2")){
            for(Session s:list){
                if(s != session){
                    try{
                        s.getBasicRemote().sendText("2#"+user+":"+txt);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }else if (no.equals("3")) {
            // 누군가 접속 > 3#아무개
            for (Session s : list) {

                if (s != session) { // 현재 접속자가 아닌 나머지 사람들
                    try {
                        s.getBasicRemote().sendText("3#" + user + "#");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            list.remove(session);
        }

    }


    @OnClose
    public void handleClose(){

    }
    @OnError
    public void handleError(Throwable t){

    }
}
