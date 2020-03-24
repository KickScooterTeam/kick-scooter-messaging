package com.softserve.messaging.dto;

import com.softserve.messaging.model.EmailType;
import lombok.Data;

@Data
public class MailMessageSortingDto {

    private String email;
    private EmailType emailType;
}
