package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailTemplateDto;

public interface MailService {

    void sendMessage(MailTemplateDto mailTemplateDto);
}
