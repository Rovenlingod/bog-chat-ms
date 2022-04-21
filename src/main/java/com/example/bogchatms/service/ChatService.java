package com.example.bogchatms.service;

import com.example.bogchatms.domain.Chat;
import com.example.bogchatms.dto.ChatDTO;

public interface ChatService {
    Chat createChat(ChatDTO chatDTO);
}
