package com.example.bogchatms.service;

import com.example.bogchatms.domain.ChatMessage;
import com.example.bogchatms.dto.ChatDTO;
import com.example.bogchatms.dto.MessageDTO;

public interface MessageService {
    ChatMessage saveMessage(MessageDTO messageDTO);
}
