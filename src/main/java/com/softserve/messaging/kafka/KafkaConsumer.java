package com.softserve.messaging.kafka;

import com.softserve.messaging.dto.MailTemplate;
import com.softserve.messaging.dto.UserReceipt;
import com.softserve.messaging.dto.UserValidation;
import com.softserve.messaging.service.MailService;
import com.softserve.messaging.service.MailTemplateDirector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final MailService mailService;
    private final MailTemplateDirector mailTemplateDirector;

    @KafkaListener(topics = "email.receipt")
    public void listenMailReceipt(UserReceipt userReceipt) {
        log.info("Received user receipt");

        MailTemplate mailTemplate = mailTemplateDirector.createReceiptTemplate(userReceipt);

        mailService.sendMessage(mailTemplate);
    }

    @KafkaListener(topics = "email.verification")
    public void listenMailVerification(UserValidation userValidation) {
        log.info("Received user verification");

        MailTemplate mailTemplate = mailTemplateDirector.createVerificationTemplate(userValidation);

        mailService.sendMessage(mailTemplate);
    }
}