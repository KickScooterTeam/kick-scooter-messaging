package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailTemplateDto;
import com.softserve.messaging.model.MessageHandler;
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

    public void sendMessage(MailTemplateDto mailTemplateDto) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(mailTemplateDto.getMail());
            helper.setSubject(mailTemplateDto.getTopic());
            helper.setText(mailTemplateDto.getBody());

            javaMailSender.send(message);

            log.info("Mail was successfully sent");
        } catch (MessagingException e) {
            log.error("Mail wasn't sent, exception: {}", e.getMessage());
        }
    }
}