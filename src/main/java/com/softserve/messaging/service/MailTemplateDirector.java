package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailTemplate;
import com.softserve.messaging.dto.UserReceipt;
import com.softserve.messaging.dto.UserValidation;
import com.softserve.messaging.util.UtilMailMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailTemplateDirector {
    private final UtilMailMessage utilMailMessage;

    public MailTemplate createReceiptTemplate(UserReceipt userReceipt) {
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setMail(userReceipt.getEmail());
        mailTemplate.setTopic(utilMailMessage.getReceiptTopic());
        mailTemplate.setBody(utilMailMessage.getReceiptBody(userReceipt));

        return mailTemplate;
    }

    public MailTemplate createVerificationTemplate(UserValidation userValidation) {
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setMail(userValidation.getEmail());
        mailTemplate.setTopic(utilMailMessage.getVerificationTopic());
        mailTemplate.setBody(utilMailMessage.getVerificationBody(userValidation));

        return mailTemplate;
    }
}
