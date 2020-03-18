package com.softserve.messaging.controller;

import com.softserve.messaging.model.MessageHandler;
import com.softserve.messaging.repository.MessageHandlerRepo;
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

    private final MessageHandlerRepo messageHandlerRepo;

    @GetMapping("/{mail}/receipts")
    public ResponseEntity<Page<MessageHandler>> getAllByMail(@PathVariable String mail, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(messageHandlerRepo.findAllByMail(mail, pageable));
    }

    @GetMapping("/all/receipts")
    public ResponseEntity<Page<MessageHandler>> getUsersPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(messageHandlerRepo.findAll(pageable));
    }

}
