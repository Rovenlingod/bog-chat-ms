package com.example.bogchatms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "chat")
@NoArgsConstructor
public class Chat {
    @Id
    @Column(name = "chat_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID chatId;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatId")
    private List<ChatMessage> messageList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Subscriber> subscribers;
}
