package com.softserve.messaging.dto;

import lombok.Data;

@Data
public class MailTemplate {
    private String mail;
    private String topic;
    private String body;
}
