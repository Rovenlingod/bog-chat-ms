package com.example.bogchatms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Effectively many-to-many table between Chat and User from user-ms
 */
@Entity
@IdClass(value = SubscriberKey.class)
@Table(name = "subscriber")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    @Id
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
    @Id
    private UUID userId;
    @Column(name = "subscriber_status")
    @Enumerated(EnumType.STRING)
    private SubscriberStatus subscriberStatus;
}
