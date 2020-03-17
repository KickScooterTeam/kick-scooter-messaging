package com.softserve.message_sender.controller;

import com.softserve.message_sender.model.MessageHandler;
import com.softserve.message_sender.repository.MessageHandlerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-receipt")
public class MessageHandlerController {

    @Value("${paging.default-page-size}")
    private int pageSize;

    private final MessageHandlerRepo messageHandlerRepo;

    @GetMapping("/all")
    public Iterable<MessageHandler> getAllReceipts() {
        return messageHandlerRepo.findAll();
    }

    @GetMapping("/{mail}/receipts")
    public Iterable<MessageHandler> getAllByMail(@PathVariable String mail) {
        return messageHandlerRepo.findAllByMail(mail);
    }

    @GetMapping("/all/receipts")
    public Page<MessageHandler> getUsersPage(@RequestParam(defaultValue = "0") int page) {
        return messageHandlerRepo.findAll(PageRequest.of(page, pageSize));
    }

}
