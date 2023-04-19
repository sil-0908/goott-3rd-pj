package com.goott.pj3.common.util;

import com.goott.pj3.user.dto.UserDTO;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/msg-ws")
public class MsgHandler extends TextWebSocketHandler {

	List<WebSocketSession> sessions = new ArrayList<>(); // 모든 세션 담는 리스트
	Map<String, WebSocketSession> userSessions = new HashMap<>();

	/**
	 * 조원재 23.04.10. 웹소켓 연결 성공
	 * @param session
	 * @throws Exception
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished : " + session);
		sessions.add(session); // 접속한 세션 리스트에 담기
		String sendId = getId(session);
		userSessions.put(sendId, session); // 로그인한 유저 세션 정보
	}
	/**
	 * 조원재 23.04.10. 웹소켓 송수신
	 * @param session
	 * @param message
	 * @throws Exception
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage: " + session + " : " + message);
		String sendId = getId(session);
		for(WebSocketSession ss : sessions){
			ss.sendMessage(new TextMessage(sendId + " : " + message.getPayload()));
		}
	}
	/**
	 * 조원재 23.04.12. 로그인한 httpsession+session 가져오기
	 * @param session
	 * @return
	 */
	private static String getId(WebSocketSession session) {
		//웹소켓세션 내 httptp세션 가져와야함.
		Map<String, Object> httpSession = session.getAttributes();
		String user_id = (String) session.getAttributes().get("user_id");
		httpSession.put("send_id", user_id);
		return (String) httpSession.get("send_id");
	}
	/**
	 * 조원재 23.04.10. 웹소켓 종료
	 * @param session
	 * @param status
	 * @throws Exception
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed : " + session + " : " + status);
	}
}
