package com.softserve.message_sender.service;

import com.softserve.message_sender.model.MessageHandler;
import com.softserve.message_sender.repository.MessageHandlerRepo;
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

    @KafkaListener(topics = "${kafka.topic.email-receipt}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailReceipt(MessageHandler messageHandler, ConsumerRecord<String, MessageHandler> record) {
        log.info("Received userReceipt from partition {}", record.partition());

        messageHandlerRepo.save(messageHandler);

        mailService.sendReceiptMessage(messageHandler);
    }

    //TODO pushMessage
}