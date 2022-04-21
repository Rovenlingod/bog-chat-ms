package com.example.bogchatms.service;

import com.example.bogchatms.domain.Chat;
import com.example.bogchatms.dto.ChatDTO;
import com.example.bogchatms.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMapper chatMapper;

    @Override
    public Chat createChat(ChatDTO chatDTO) {
        Chat chat = chatMapper.toEntity(chatDTO);
        return null;
    }
}
