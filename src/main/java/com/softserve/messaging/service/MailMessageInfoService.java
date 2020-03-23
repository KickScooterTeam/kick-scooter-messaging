package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.dto.MailMessageInfoFilter;
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

    public Page<MailMessageInfoDto> getMessages(MailMessageInfoFilter mailMessageInfoFilter, Pageable pageable) {

        return mailMessageInfoRepo.findAll(mailMessageInfoFilter, pageable)
                .map(mailMessageInfo -> conversionService.convert(mailMessageInfo, MailMessageInfoDto.class));
    }
}
