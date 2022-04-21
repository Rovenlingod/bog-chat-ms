package com.example.bogchatms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload HelloMessage chatMessage) {
//        var chatId = chatRoomService
//                .getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
//        chatMessage.setChatId(chatId.get());
//
//        ChatMessage saved = chatMessageService.save(chatMessage);
        System.out.println(chatMessage);
        messagingTemplate.convertAndSendToUser(
                "22a57e60-76bb-4be4-809a-0bab2842cf38","/queue/messages",
                "123");
    }
}
