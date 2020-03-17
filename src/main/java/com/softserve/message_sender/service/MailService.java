package com.softserve.message_sender.service;

import com.softserve.message_sender.model.MessageHandler;

public interface MailService {

    void sendReceiptMessage(MessageHandler messageHandler);

    //TODO email verification
}
