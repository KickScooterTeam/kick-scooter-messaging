package com.softserve.messaging.model;

import com.softserve.messaging.dto.MailMessageSortingDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MailMessageInfoSpecification {

    public static Specification<MailMessageInfo> findByParameters(final MailMessageSortingDto mailMessageSortingDto) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (mailMessageSortingDto.getEmail() != null && !mailMessageSortingDto.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("email"), mailMessageSortingDto.getEmail()));
            }
            if (mailMessageSortingDto.getEmailType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("emailType"), mailMessageSortingDto.getEmailType()));
            }

            return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
