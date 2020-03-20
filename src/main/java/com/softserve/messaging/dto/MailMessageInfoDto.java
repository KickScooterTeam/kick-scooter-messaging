package com.softserve.messaging.dto;

import com.softserve.messaging.model.EmailTarget;
import lombok.Data;

@Data
public class MailMessageInfoDto {

    private String email;
    private EmailTarget emailTarget;
    private String fieldsSummary;
}
