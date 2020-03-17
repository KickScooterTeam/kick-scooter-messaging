package com.softserve.message_sender.service;

import com.softserve.message_sender.model.UserReceipt;
import com.softserve.message_sender.repository.UserReceiptRepo;
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
    private final UserReceiptRepo userReceiptRepo;

    @KafkaListener(topics = "${kafka.topic.email-receipt}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailReceipt(UserReceipt userReceipt, ConsumerRecord<String, UserReceipt> record) {
        log.info("Received userReceipt from partition {}", record.partition());

        userReceiptRepo.save(userReceipt);

        mailService.sendReceiptMessage(userReceipt);
    }

    //TODO pushMessage
}