package com.softserve.messaging.util;

import com.softserve.messaging.dto.UserReceipt;
import com.softserve.messaging.dto.UserValidation;
import org.springframework.stereotype.Component;

@Component
public class UtilMailMessage {

    private String receiptTopic = "Electronic receipt";
    private String receiptBody = "Hello, %s. Thanks for a ride. We hope you've enjoyed it.%nTotal cost: %.2f %s";

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

    public String getReceiptBody(UserReceipt userReceipt) {
        return String.format(receiptBody,
                userReceipt.getFirstName(), userReceipt.getTripCost(), userReceipt.getCurrency());
    }

    public String getVerificationBody(UserValidation userValidation) {
        return String.format(verificationBody, userValidation.getVerificationPath());
    }


}
