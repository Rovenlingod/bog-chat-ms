package com.example.bogchatms.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private String senderId;
    private String content;
    private String chatId;
}
