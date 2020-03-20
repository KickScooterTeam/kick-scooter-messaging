package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.model.EmailType;
import com.softserve.messaging.repository.MailMessageInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailMessageInfoService {
    private final MailMessageInfoRepo mailMessageInfoRepo;
    private final ConversionService conversionService;

    public Page<MailMessageInfoDto> getAllByEmail(String email, Pageable pageable) {

        return mailMessageInfoRepo.findAllByEmail(email, pageable)
                .map(mailMessageInfo -> conversionService.convert(mailMessageInfo, MailMessageInfoDto.class));
    }

    public Page<MailMessageInfoDto> getAllByEmailAndEmailType(String email, EmailType emailType, Pageable pageable) {

        return mailMessageInfoRepo.findAllByEmailAndEmailType(email, emailType, pageable)
                .map(mailMessageInfo -> conversionService.convert(mailMessageInfo, MailMessageInfoDto.class));
    }
}
