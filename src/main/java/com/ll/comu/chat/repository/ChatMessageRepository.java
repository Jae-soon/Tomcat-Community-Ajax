package com.ll.comu.chat.repository;

import com.ll.comu.chat.dto.ChatMessageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatMessageRepository {
    private static List<ChatMessageDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() {
        IntStream.rangeClosed(1, 10).forEach(roomId -> {
            IntStream.rangeClosed(1, 2).forEach(id -> {
                String content = "메세지 %d".formatted(id);
                write(roomId, content);
            });
        });
    }

    public static long write(long roomId, String content) {
        long id = ++lastId;
        ChatMessageDto newChatMessageDto = new ChatMessageDto(id, roomId, content);

        datum.add(newChatMessageDto);

        return id;
    }

    public List<ChatMessageDto> findByRoomId(long roomId) {
        return datum
                .stream()
                .filter(chatMessageDto -> chatMessageDto.getRoomId() == roomId)
                .collect(Collectors.toList());
    }

    public List<ChatMessageDto> findByRoomIdGreaterThan(long roomId, long fromId) {
        return datum
                .stream()
                .filter(chatMessageDto -> chatMessageDto.getRoomId() == roomId)
                .filter(chatMessageDto -> chatMessageDto.getId() > fromId)
                .collect(Collectors.toList());
    }

    public ChatMessageDto findById(long id) {
        for (ChatMessageDto chatMessageDto : datum) {
            if (chatMessageDto.getId() == id) {
                return chatMessageDto;
            }
        }

        return null;
    }


    public void deleteMessage(long id) {
        ChatMessageDto chatMessageDto = findById(id);

        if (chatMessageDto == null) {
            return;
        }

        datum.remove(chatMessageDto);
    }

    public void modifyMessage(long id, String content) {
        ChatMessageDto chatMessageDto = findById(id);

        if (chatMessageDto == null) {
            return;
        }

        chatMessageDto.setContent(content);
    }
}
