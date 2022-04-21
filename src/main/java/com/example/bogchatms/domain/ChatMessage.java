package com.example.bogchatms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    @Id
    @Column(name = "message_id")
    @Type(type="uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "chat_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Column(name = "sender_id")
    private UUID senderId;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "message_status")
    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;
}
