package com.softserve.messaging.repository;

import com.softserve.messaging.model.MessageHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageHandlerRepo extends PagingAndSortingRepository<MessageHandler, Long> {
    Page<MessageHandler> findAllByMail(String mail, Pageable pageable);
}
