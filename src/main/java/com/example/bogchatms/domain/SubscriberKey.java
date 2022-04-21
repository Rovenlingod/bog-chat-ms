package com.example.bogchatms.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class SubscriberKey implements Serializable {

    private UUID chat;
    private UUID userId;

}
