package com.softserve.messaging.converter;

import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.EmailTarget;
import com.softserve.messaging.model.MailMessageInfo;
import org.springframework.core.convert.converter.Converter;

public class UserReceiptToMailMessageInfo implements Converter<UserReceipt, MailMessageInfo> {
    @Override
    public MailMessageInfo convert(UserReceipt userReceipt) {
        MailMessageInfo mailMessageInfo = new MailMessageInfo();

        mailMessageInfo.setEmail(userReceipt.getEmail());
        mailMessageInfo.setEmailTarget(EmailTarget.RECEIPT);
        mailMessageInfo.setFieldsSummary(userReceipt.toString());

        return mailMessageInfo;
    }
}
