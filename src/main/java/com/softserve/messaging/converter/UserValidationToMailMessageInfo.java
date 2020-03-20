package com.softserve.messaging.converter;

import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.model.EmailTarget;
import com.softserve.messaging.model.MailMessageInfo;
import org.springframework.core.convert.converter.Converter;

public class UserValidationToMailMessageInfo implements Converter<UserValidation, MailMessageInfo> {
    @Override
    public MailMessageInfo convert(UserValidation userValidation) {
        MailMessageInfo mailMessageInfo = new MailMessageInfo();

        mailMessageInfo.setEmail(userValidation.getEmail());
        mailMessageInfo.setEmailTarget(EmailTarget.VERIFICATION);
        mailMessageInfo.setFieldsSummary(userValidation.toString());

        return mailMessageInfo;
    }
}
