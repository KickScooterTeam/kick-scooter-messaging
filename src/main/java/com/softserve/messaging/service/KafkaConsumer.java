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

    @KafkaListener(topics = "${kafka.topic.email-receipt}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailReceipt(MessageHandler messageHandler, ConsumerRecord<String, MessageHandler> record) {
        log.info("Received userReceipt from partition {}", record.partition());

        MailTemplateDto mailTemplateDto = mailTemplateDirector.createReceiptTemplate(messageHandler);

        mailService.sendMessage(mailTemplateDto);
        messageHandlerRepo.save(messageHandler);
    }

    @KafkaListener(topics = "${kafka.topic.email-verification}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailVerification(MessageHandler messageHandler) {
        log.info("Received user verification");

        MailTemplateDto mailTemplateDto = mailTemplateDirector.createVerificationTemplate(messageHandler);

        mailService.sendMessage(mailTemplateDto);
        messageHandlerRepo.save(messageHandler);
    }
}