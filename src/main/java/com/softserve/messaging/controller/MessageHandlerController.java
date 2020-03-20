package com.softserve.messaging.controller;

import com.softserve.messaging.model.MailMessageInfo;
import com.softserve.messaging.repository.MailMessageInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messaging/mailing")
public class MessageHandlerController {

    private final MailMessageInfoRepo mailMessageInfoRepo;

    @GetMapping("/{email}/receipts")
    public ResponseEntity<Page<MailMessageInfo>> getAllByMail(@PathVariable String email, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(mailMessageInfoRepo.findAllByEmail(email, pageable));
    }

    @GetMapping("/all/receipts")
    public ResponseEntity<Page<MailMessageInfo>> getUsersPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(mailMessageInfoRepo.findAll(pageable));
    }

}
