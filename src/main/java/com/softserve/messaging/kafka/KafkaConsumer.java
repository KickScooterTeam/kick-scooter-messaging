package com.softserve.messaging.kafka;

import com.softserve.messaging.model.MailMessageInfo;
import com.softserve.messaging.model.MailTemplate;
import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.repository.MailMessageInfoRepo;
import com.softserve.messaging.service.MailService;
import com.softserve.messaging.service.MailTemplateDirector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final MailService mailService;
    private final MailTemplateDirector mailTemplateDirector;
    private final MailMessageInfoRepo mailMessageInfoRepo;
    private final ConversionService conversionService;

    @SuppressWarnings("ConstantConditions")
    @KafkaListener(topics = "email.receipt")
    public void listenMailReceipt(UserReceipt userReceipt) {
        log.info("Received user receipt");

        MailTemplate mailTemplate = mailTemplateDirector.createReceiptTemplate(userReceipt);
        mailService.sendMessage(mailTemplate);

        mailMessageInfoRepo.save(conversionService.convert(userReceipt, MailMessageInfo.class));
    }

    @SuppressWarnings("ConstantConditions")
    @KafkaListener(topics = "email.verification", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailVerification(UserValidation userValidation) {
        log.info("Received user verification");

        MailTemplate mailTemplate = mailTemplateDirector.createVerificationTemplate(userValidation);
        mailService.sendMessage(mailTemplate);

        mailMessageInfoRepo.save(conversionService.convert(userValidation, MailMessageInfo.class));
    }
}