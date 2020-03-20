package com.softserve.messaging.repository;

import com.softserve.messaging.model.EmailTarget;
import com.softserve.messaging.model.MailMessageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MailMessageInfoRepo extends PagingAndSortingRepository<MailMessageInfo, Long> {
    Page<MailMessageInfo> findAllByEmail(String email, Pageable pageable);
    Page<MailMessageInfo> findAllByEmailAndEmailType(String email, EmailTarget emailTarget, Pageable pageable);
}
