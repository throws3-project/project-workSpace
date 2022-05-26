package com.project.workspace.controller;

import com.project.workspace.domain.repository.ChatRoomRepository;
import com.project.workspace.domain.repository.UserRepository;
import com.project.workspace.domain.vo.ChatRoom;
import com.project.workspace.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    //user목록 가져오기
    @GetMapping("/list")
    public List<String> List(){
        List<String> list = userRepository.findAll().stream().map(UserVO::getUserId).collect(Collectors.toList());
        return list;
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", chatRoomRepository.findAllRoom());
        return "home";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model) {
        ChatRoom room = chatRoomRepository.findRoomById(id);
        model.addAttribute("room", room);
        log.info("++++++++++++++++++++++++++++++48++++++++++++++++");
        log.info(id);
        return "test";
    }

    @GetMapping("/new")
    public String make(Model model) {
        ChatRoomForm form = new ChatRoomForm();
        model.addAttribute("form", form);
        return "newRoom";
    }

    @PostMapping("/room/new")
    public String makeRoom(@RequestBody String name) {

        chatRoomRepository.createChatRoom(name);
        log.info("*******************************************************");
        log.info("방 만들기 컨트롤러 들어옴");
        log.info(name);
        log.info("*******************************************************");

        return "home";
    }


}
