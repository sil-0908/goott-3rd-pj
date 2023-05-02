package com.goott.pj3.common.util.chat;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.*;

// 2023.04.28 길영준
// 추후 내용 DB저장으로 고도화해야함
// 2023.04.29 길영준
// DB저장으로 고도화 완료
// 2023.05.01 길영준
// 메세지 로그 저장 구현
//2023.05.02 길영준
// 로그 저장 후 로딩, 읽음확인, 방목록 안읽은 메세지 확인 추가
@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoomDTO> chatRoomDTOMap;
    final
    SqlSession session;

    public ChatRoomRepository(SqlSession session) {
        this.session = session;
    }

    //채팅방 만들기
    public void createChatRoomDTO(ChatRoomDTO chatRoomDTO) {
        session.insert("chat.create", chatRoomDTO);
    }

    // 소유하고있는 모든 채팅방 리스트 가져오기
    public List<ChatRoomDTO> findAllRooms(String user_id) {
        return session.selectList("chat.findAllRooms", user_id);
    }

    // 채팅방ID로 채팅찾기
    public ChatRoomDTO findRoomById(ChatRoomDTO chatRoomDTO) {
        return session.selectOne("chat.findRoomById", chatRoomDTO);
    }

    // 보내는 사람 받는사람 이름으로 채팅방이 이미 존재하는지 확읺하고
    // 있다면 채팅방ID를 리턴한다
    public ChatRoomDTO findRoomByName(ChatRoomDTO chatRoomDTO) {
        return session.selectOne("chat.findRoomByName", chatRoomDTO);
    }

    //메세지로그 저장
    public void saveMessageLog(ChatMessageDTO chatMessageDTO) {
        session.insert("chat.saveMessageLog", chatMessageDTO);
    }
    //메세지로그 불러오기
    public List<ChatMessageDTO> findMessageLog(int msg_idx) {
        return session.selectList("chat.findMessageLog", msg_idx);
    }
    //읽었나 안읽었나 확인
    public void readNtoY(Map<String, String> map) {
        session.update("chat.readNtoY", map);
    }
    // 채팅방 생성시 안읽은 메세지가 있는방 표시
    public List<ChatRoomDTO> checkReadOrNot(String sessionId) {
        ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
        System.out.println(session.selectList("chat.checkReadorNot", sessionId));
        chatRoomDTO.setReceive_id(sessionId);
        return session.selectList("chat.checkReadorNot", chatRoomDTO);
    }
}
