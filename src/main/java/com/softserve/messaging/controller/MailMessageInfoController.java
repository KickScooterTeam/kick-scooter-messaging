package com.softserve.messaging.controller;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.dto.MailMessageSortingDto;
import com.softserve.messaging.service.MailMessageInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MailMessageInfoController {

    private final MailMessageInfoService mailMessageInfoService;

    @GetMapping
    public ResponseEntity<Page<MailMessageInfoDto>> getMessages(MailMessageSortingDto mailMessageSortingDto,
                                                                Pageable pageable) {
        return ResponseEntity.ok(mailMessageInfoService.getMessages(mailMessageSortingDto, pageable));
    }

}
