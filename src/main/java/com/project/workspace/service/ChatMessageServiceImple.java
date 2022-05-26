package com.project.workspace.service;

import com.project.workspace.domain.dao.ChatMessageDAO;
import com.project.workspace.domain.vo.ChatMessageMyBatisVO;
import com.project.workspace.domain.vo.ChatMessageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatMessageServiceImple implements ChatMessageService {

    public final ChatMessageDAO chatMessageDAO;


    @Override
    public void insertRoom(String senderId, String receiverId, String roomName) {
        chatMessageDAO.insertRoom(senderId,receiverId,roomName);
    }

    @Override
    public List<ChatMessageMyBatisVO> getChatList(String senderId, String receiverId) {
        return chatMessageDAO.getChatList(senderId, receiverId);
    }

    @Override
    public List<ChatMessageVO> getMyChatList(String senderId, String receiverId) {
        return chatMessageDAO.getMyChatList(senderId, receiverId);
    }

    @Override
    public List<ChatMessageVO> getConnectRoomName(String senderId, String receiverId) {
        return chatMessageDAO.getConnectRoomName(senderId, receiverId);
    }

    @Override
    public boolean getChatHistory(String senderId, String receiverId) {
        return chatMessageDAO.getChatHistory(senderId, receiverId);
    }



}
