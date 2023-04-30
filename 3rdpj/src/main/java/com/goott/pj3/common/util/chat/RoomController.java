package com.goott.pj3.common.util.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

//2023.04.28길영준
@RequestMapping(value = "/chat")
@Controller
public class RoomController {

    private final ChatRoomRepository repository;

    public RoomController(ChatRoomRepository repository) {
        this.repository = repository;
    }

    //채팅방 목록 조회
    @GetMapping(value = "/rooms/{user_id}")
    public ModelAndView rooms(@PathVariable("user_id") String user_id, HttpSession httpSession, ModelAndView mv) {
        String sessionId = String.valueOf(httpSession.getAttribute("user_id"));
        if (sessionId.equals(user_id)) { //뷰에서 넘어온 user_id와 session user_id를 비교해서 일치하면 채팅방 목록을 보여줌
//        ModelAndView mv = new ModelAndView("/plan/rooms");
            mv.setViewName("/plan/rooms");
            mv.addObject("list", repository.findAllRooms(sessionId)); //세션아이디가 가지고 있는 모든 채팅방 리스트 가져오기
        } else {
            mv.setViewName("redirect:/user/signin");    //일치하지 않으면 로그인페이지로 보냄
        }
        return mv;
    }
    //채팅방 개설
//    @PostMapping(value = "/room")
//    public String create(@RequestParam String name, RedirectAttributes rttr) {
//        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
//        return "redirect:/chat/rooms";
//    }
    //채팅방 개설
    @PostMapping(value = "/room") //form으로 받는데이터 = send_id & receive_id
    public String create(ChatRoomDTO chatRoomDTO, ModelAndView mv) {
        if (chatRoomDTO.getSend_id().equals(chatRoomDTO.getReceive_id())) {
            return "redirect:/plan/list";   // 플래너가 본인에게 채팅 요청했을시
        }
        ChatRoomDTO formData = chatRoomDTO; // 폼에서 받아온 dto
        System.out.println("폼으로 받아온 dto : " + formData.toString());

        if (repository.findRoomByName(formData) != null) {  //이미 해당 플래너와 채팅방이 존재하면 존재하는 방으로 이동시킴
            int msg_idx = repository.findRoomByName(formData).getMsg_idx();
            System.out.println("방이 존재할때 가져온 방 idx : " + msg_idx);
            return "redirect:/chat/room/" + msg_idx;
        } else {                                             //없다면 새로 생성해주고 방으로 이동
            repository.createChatRoomDTO(formData);
            int msg_idx = chatRoomDTO.getMsg_idx();
            System.out.println("방만들고 받아온 idx : " + chatRoomDTO.getMsg_idx());
            return "redirect:/chat/room/" + msg_idx;
        }
    }

    // 실제 채팅방
    @GetMapping("/room/{msg_idx}")
    public String getRoom(@PathVariable("msg_idx") int msg_idx, Model model, HttpSession httpSession) {
        String sessionAuth = String.valueOf(httpSession.getAttribute("auth"));
        String user = "";
        String planner = "";
        if (sessionAuth.equals("auth_c")) { //무분별한 겟요청으로 채팅방 열람을 막기위해 세션아이디를 가져옴
            user = String.valueOf(httpSession.getAttribute("user_id")); // 유저 일때 아이디
            System.out.println("유저아이디 : " + user);
        } else if (sessionAuth.equals("auth_b")) {
            planner = String.valueOf(httpSession.getAttribute("user_id"));  // 플래너 일때 아이디
            System.out.println("플래너아이디 : " + planner);
        } else {
            return "redirect:/main"; // 둘다 아니면 메인으로
        }
        ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
        chatRoomDTO.setMsg_idx(msg_idx);
        chatRoomDTO = repository.findRoomById(chatRoomDTO);
        if (chatRoomDTO.getSend_id().equals(user)
                || chatRoomDTO.getReceive_id().equals(planner)) { // 보낸아이디와 세션유저아이디가 맞거나
            model.addAttribute("room", chatRoomDTO);  // 받은아이디와 세션플래너아이디가 맞으면
            return "/plan/room";
        } else {
            return "redirect:/main";                            // 아닐경우 메인으로
        }
    }
}
