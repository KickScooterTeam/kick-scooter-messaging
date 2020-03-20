package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailTemplateDto;
import com.softserve.messaging.model.MessageHandler;
import com.softserve.messaging.repository.MessageHandlerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final MailService mailService;
    private final MessageHandlerRepo messageHandlerRepo;
    private final MailTemplateDirector mailTemplateDirector;

    @KafkaListener(topics = "email.receipt")
    public void listenMailReceipt(MessageHandler messageHandler) {
        log.info("Received user receipt");

        MailTemplateDto mailTemplateDto = mailTemplateDirector.createReceiptTemplate(messageHandler);

        mailService.sendMessage(mailTemplateDto);
        messageHandlerRepo.save(messageHandler);
    }

    @KafkaListener(topics = "email.verification")
    public void listenMailVerification(MessageHandler messageHandler) {
        log.info("Received user verification");

        MailTemplateDto mailTemplateDto = mailTemplateDirector.createVerificationTemplate(messageHandler);

        mailService.sendMessage(mailTemplateDto);
        messageHandlerRepo.save(messageHandler);
    }
}