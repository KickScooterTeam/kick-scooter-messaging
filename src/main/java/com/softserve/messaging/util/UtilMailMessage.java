package com.softserve.messaging.util;

import com.softserve.messaging.model.MessageHandler;
import org.springframework.stereotype.Component;

@Component
public class UtilMailMessage {

    private String receiptTopic = "Electronic receipt";
    private String receiptBody = "Hello, %s. Thanks for a ride. We hope you've enjoyed it.%nTotal cost: %.2f $";

    private String verificationTopic = "Email verification";
    private String verificationBody = "Hello. Thanks for signing up. You're almost there.%n" +
            "Please confirm your registration by clicking the link below.%n" +
            "https://www.localhost:8080/%s";

    public String getReceiptTopic() {
        return receiptTopic;
    }

    public String getVerificationTopic() {
        return verificationTopic;
    }

    public String getReceiptBody(MessageHandler messageHandler) {
        return String.format(receiptBody, messageHandler.getFirstName(), messageHandler.getCost());
    }

    public String getVerificationBody(MessageHandler messageHandler) {
        return String.format(verificationBody, messageHandler.getToken());
    }


}
