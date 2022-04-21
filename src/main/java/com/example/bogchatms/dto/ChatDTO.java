package com.example.bogchatms.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatDTO {

    private String title;
    private MessageDTO initMessage;
    private String creatorId;
    private List<String> subscriberIds;
}
