package com.softserve.message_sender.service;

import com.softserve.message_sender.model.MessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public void sendReceiptMessage(MessageHandler messageHandler) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(messageHandler.getMail());
            helper.setSubject(MessageHandler.TITLE);
            helper.setText(messageHandler.toString());

            javaMailSender.send(message);
            log.info("Mail was successfully sent");
        } catch (MessagingException e) {
            log.error("Mail wasn't sent, exception: {}", e.getMessage());
        }
    }
}