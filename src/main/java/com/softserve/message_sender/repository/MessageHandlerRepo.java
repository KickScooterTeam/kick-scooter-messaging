package com.softserve.message_sender.repository;

import com.softserve.message_sender.model.MessageHandler;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface MessageHandlerRepo extends PagingAndSortingRepository<MessageHandler, Long> {
    Iterable<MessageHandler> findAllByMail(String mail);
    Iterable<MessageHandler> findAllByLocalDateTime(LocalDateTime date);

}
