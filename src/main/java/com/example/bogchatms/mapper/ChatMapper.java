package com.example.bogchatms.mapper;

import com.example.bogchatms.domain.Chat;
import com.example.bogchatms.dto.ChatDTO;

public abstract class ChatMapper {
    public abstract Chat toEntity(ChatDTO chatDTO);
}
