package com.ll.comu.chat.service;

import com.ll.comu.chat.dto.ChatRoomDto;
import com.ll.comu.chat.repository.ChatRoomRepository;

import java.util.List;

public class ChatService {
    private ChatRoomRepository chatRoomRepository;

    public ChatService() {
        chatRoomRepository = new ChatRoomRepository();
    }
    public long createRoom(String title, String content) {
        return chatRoomRepository.create(title, content);
    }

    public List<ChatRoomDto> findAllRooms() {
        return chatRoomRepository.findAll();
    }
}
