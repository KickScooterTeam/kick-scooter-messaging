package com.softserve.message_sender.repository;

import com.softserve.message_sender.model.UserReceipt;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface UserReceiptRepo extends PagingAndSortingRepository<UserReceipt, Long> {
    Iterable<UserReceipt> findAllByMail(String mail);
    Iterable<UserReceipt> findAllByLocalDateTime(LocalDateTime date);

}
