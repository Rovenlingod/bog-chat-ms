package com.example.bogchatms.controller;

import com.example.bogchatms.domain.Chat;
import com.example.bogchatms.domain.ChatMessage;
import com.example.bogchatms.domain.Subscriber;
import com.example.bogchatms.dto.ChatDTO;
import com.example.bogchatms.dto.MessageDTO;
import com.example.bogchatms.service.ChatService;
import com.example.bogchatms.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;
    private final MessageService messageService;

    @MessageMapping("/create/chat")
    public void createChat(@Payload ChatDTO chat) {
        Chat createdChat = chatService.createChat(chat);
        for (Subscriber subscriber : createdChat.getSubscribers()) {
            messagingTemplate.convertAndSend("/queue/chats/" + subscriber.getUserId(), chat.getInitMessage());
        }
    }

    @MessageMapping("/send/message")
    public void sendMessage(@Payload MessageDTO message) {
        ChatMessage createdMessage = messageService.saveMessage(message);
        messagingTemplate.convertAndSend("/topic/chat/" + createdMessage.getChat().getChatId(), message);
        for (Subscriber subscriber : createdMessage.getChat().getSubscribers()) {
            messagingTemplate.convertAndSend("/queue/chats/" + subscriber.getUserId(), message);
        }
    }
}
