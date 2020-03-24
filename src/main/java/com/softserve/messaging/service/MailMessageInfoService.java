package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.dto.MailMessageSortingDto;
import com.softserve.messaging.model.MailMessageInfo;
import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.repository.MailMessageInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.softserve.messaging.model.MailMessageInfoSpecification.findByParameters;

@Service
@RequiredArgsConstructor
public class MailMessageInfoService {

    private final MailMessageInfoRepo mailMessageInfoRepo;
    private final ConversionService conversionService;

    public Page<MailMessageInfoDto> getMessages(MailMessageSortingDto mailMessageSortingDto, Pageable pageable) {

        return mailMessageInfoRepo.findAll(findByParameters(mailMessageSortingDto), pageable)
                .map(mailMessageInfo -> conversionService.convert(mailMessageInfo, MailMessageInfoDto.class));
    }

    public MailMessageInfo saveUserReceipt(UserReceipt userReceipt) {
        return mailMessageInfoRepo.save(conversionService.convert(userReceipt, MailMessageInfo.class));
    }

    public MailMessageInfo saveUserValidation(UserValidation userValidation) {
        return mailMessageInfoRepo.save(conversionService.convert(userValidation, MailMessageInfo.class));
    }

}
