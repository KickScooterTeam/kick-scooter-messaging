package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailTemplateDto;
import com.softserve.messaging.model.MessageHandler;
import com.softserve.messaging.util.UtilMailMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailTemplateDirector {
    private final UtilMailMessage utilMailMessage;

    public MailTemplateDto createReceiptTemplate(MessageHandler messageHandler) {
        MailTemplateDto mailTemplateDto = new MailTemplateDto();
        mailTemplateDto.setMail(messageHandler.getMail());
        mailTemplateDto.setTopic(utilMailMessage.getReceiptTopic());
        mailTemplateDto.setBody(utilMailMessage.getReceiptBody(messageHandler));

        return mailTemplateDto;
    }

    public MailTemplateDto createVerificationTemplate(MessageHandler messageHandler) {
        MailTemplateDto mailTemplateDto = new MailTemplateDto();
        mailTemplateDto.setMail(messageHandler.getMail());
        mailTemplateDto.setTopic(utilMailMessage.getVerificationTopic());
        mailTemplateDto.setBody(utilMailMessage.getVerificationBody(messageHandler));

        return mailTemplateDto;
    }
}
